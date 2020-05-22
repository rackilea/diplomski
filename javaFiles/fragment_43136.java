try {
  URL u = getClass().getClassLoader().getResource("templates");
  File f = new File(u.getFile());
  File[] dir = f.listFiles();
  for(int i=0;i<dir.length;i++) {
    System.out.println(dir[i].getName());
  }
} catch(Exception e) {
  e.printStackTrace();
}