package com.example;

import ca.uhn.fhir.rest.server.interceptor.consent.ConsentInterceptor;
import ca.uhn.fhir.rest.server.interceptor.consent.IConsentService;

public class EmptyConsentInterceptor extends ConsentInterceptor {

    private static IConsentService myConsentservice = new EmptyConsentService();

    public EmptyConsentInterceptor() {
        super(myConsentservice);
    }

}
