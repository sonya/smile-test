# smile config comparisons

This is a minimally reproducible demonstration of Smile CDR configuration differences.

1. Build the comparison images
   ```sh
   docker build -f Dockerfile-default -t smile-default .
   docker build -f Dockerfile-modified -t smile-modified .
   ```

2. Run the default image.
   ```sh
   docker run --rm smile-default
   ```

3. Run the modified image.
   ```sh
   docker run --rm smile-modified
   ```
