Bitmap bitmapImage; //your input bitmap to save   

File storagePath = Environment.getExternalStorageDirectory();
OutputStream output = new FileOutputStream(storagePath + "/myImage.png")

try {           
    // Use the compress method on the BitMap object to write image to the OutputStream
    bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, output);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        output.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}