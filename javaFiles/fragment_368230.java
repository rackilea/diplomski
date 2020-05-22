try {
   FileOutputStream out = new FileOutputStream(filename);
   bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
} catch (Exception e) {
   e.printStackTrace();
}
out.flush();
out.close();