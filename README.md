# StructureDefinition query demo

This repo contains a minimal docker-compose stack for Smile CDR and a Postgres database and some validation configuration tweaks.
Notably, we seed base validation resources in addition to the US Core IG package.

The postgres container is configured to log all statements.

The behavior of note occurs on any request that triggers validation resources to be loaded.

Steps to reproduce:
1. Start the stack with `docker-compose up`
2. Wait for Smile to finish starting up
3. Make a POST request to an endpoint that triggers loading of validation resources:
   ```
   curl -u 'admin:password' -H 'Content-Type: application/fhir+json' -X POST http://localhost:8000/Patient/$validate -d '{"resource_type": "Patient"}'
   ```
4. Observe identical database queries being made for each StructureDefinition record

