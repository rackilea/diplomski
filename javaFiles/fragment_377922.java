public String More ...getCanonicalPath() throws IOException {
        if (isInvalid()) {
          throw new IOException("Invalid file path");
         }
         return fs.canonicalize(fs.resolve(this));
     }