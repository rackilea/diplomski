class FileHolder {
   private final File file;
   FileHolder(File f) {
      this.file = f;
   }
   public String toString() {
      return this.file.getName();
   }
}