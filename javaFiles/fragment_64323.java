File[] files = new File("icons").listFiles(new FileFilter() {
   @Override
   public boolean accept(File f) {
      return !f.isDirectory() && f.canRead();
   }
});
for (File f : files) {
   System.out.println(f.getAbsolutePath());
}