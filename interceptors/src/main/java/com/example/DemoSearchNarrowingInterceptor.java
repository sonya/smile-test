package com.example;

import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.server.interceptor.auth.AuthorizedList;
import ca.uhn.fhir.rest.server.interceptor.auth.SearchNarrowingInterceptor;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoSearchNarrowingInterceptor extends SearchNarrowingInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(DemoSearchNarrowingInterceptor.class);

    @Override
    protected AuthorizedList buildAuthorizedList(RequestDetails theRequestDetails) {
        Map<String, String[]> params = theRequestDetails.getParameters();
        String message = "in buildAuthorizedList for "+theRequestDetails.getResourceName()+" with params";
        for (var entry : params.entrySet()) {
            message += " " + entry.getKey() + "/" + String.join(",", entry.getValue());
        }
        logger.info(message);        

        Object previous = theRequestDetails.getUserData().get("PREVIOUS_USER_DATA");
        if (previous != null) {
            logger.info("this RequestDetails has been seen " + previous + " times");
            theRequestDetails.getUserData().put("PREVIOUS_USER_DATA", ((Integer) previous) + 1); 
        } else {
            logger.info("this RequestDetails has been seen 0 times");
            theRequestDetails.getUserData().put("PREVIOUS_USER_DATA", 1); 
        }

        return new AuthorizedList();
    }

}
