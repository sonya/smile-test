# smile config comparisons

This is a minimally reproducible demonstration of Smile CDR configuration differences.

1. Build the interceptors
   ```sh
   cd interceptors
   mvn compile
   ```

2. Build the comparison images
   ```sh
   docker build -f Dockerfile-default -t smile-default .
   docker build -f Dockerfile-modified -t smile-modified .
   ```

3. Run the default image.
   ```sh
   docker run -p 8000:8000 smile-default
   ```

4. Run the modified image.
   ```sh
   docker run -p 8000:8000 smile-modified
   ```
