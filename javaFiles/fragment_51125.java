File yourDir = new File(Environment.getExternalStorageDirectory(), "Testapp");
for (File f : yourDir.listFiles()) {
if (f.isFile()){
    String name = f.getName();
    if(name.equals("music1.mp3")) {
    // music1.mp3 present
    } else if(name.equals("music2.mp3")) {
    // music2.mp3 present
    }
  }
}