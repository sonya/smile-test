# client\_id\_mode configuration behavior

This is a minimally reproducible test case that shows the behavior when setting `client_id_mode=NOT_ALLOWED` in an empty Smile CDR image.

1. Build the comparison images
   ```sh
   docker build -f Dockerfile-default -t smile-default .
   docker build -f Dockerfile-modified -t smile-modified .
   ```

2. Run the default image. All modules will start successfully.
   ```sh
   docker run --rm smile-default
   ```

3. Run the modified image. There will be many exception stack traces in the logs. The `subscription`, `fhir_endpoint`, `persistence`, `fhirweb_endpoint`, and  `package_registry` moduels will fail to start.
   ```sh
   docker run --rm smile-modified
   ```
