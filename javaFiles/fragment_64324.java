File parent = new File("icons");
String[] fileStr = parent.list(new FilenameFilter() {
   @Override
   public boolean accept(File dir, String name) {
      File f = new File(dir, name);
      return !f.isDirectory() && f.canRead();
   }
});
for (String f : fileStr) {
   System.out.println(new File(parent, f).getAbsolutePath());
}