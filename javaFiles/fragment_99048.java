class SafeFile extends File {
   SafeFile(File parent, String child) throws SecurityException {
      super(parent,child);
      try {
         if(!getCanonicalPath().startsWith(parent.getCanonicalPath()))
            throw new SecurityException(child+" is above the designated directory");
      } catch(IOException e) {
         throw new SecurityException("Cannot confirm safety");
      }
   }
}