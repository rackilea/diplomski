//-- Saving file
String filename = "pippo.jpg";
File sd = Environment.getExternalStorageDirectory();
File dest = new File(sd, filename);

Bitmap bitmap = (Bitmap)data.getExtras().get("data");
try {
     FileOutputStream out = new FileOutputStream(dest);
     bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
     out.flush();
     out.close();
} catch (Exception e) {
     e.printStackTrace();
}

//-- show bitmap to imageview
imageLoader.displayImage(dest.getAbsolutePath(), imageView);