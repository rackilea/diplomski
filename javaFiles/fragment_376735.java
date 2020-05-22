File sdCardRoot = Environment.getExternalStorageDirectory();
File yourDir = new File(sdCardRoot, "yourpath");
for (File f : yourDir.listFiles()) {
    if (f.isFile())
        String name = f.getName();
        // make something with the name
}