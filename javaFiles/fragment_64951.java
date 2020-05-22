public File(String pathname) {
     if (pathname == null) {
         throw new NullPointerException();
     }
     this.path = fs.normalize(pathname);
     this.prefixLength = fs.prefixLength(this.path);
}