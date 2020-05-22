FileOutputStream out = null;
 try {
out = new FileOutputStream(filename);
bmp.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap    instance
// PNG is a lossless format, the compression factor (100) is ignored
} catch (Exception e) {
e.printStackTrace();
} 
   try {
    if (out != null) {
        out.close();
    }
} catch (IOException e) {
    e.printStackTrace();

}