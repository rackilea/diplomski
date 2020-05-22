InputStream in = getResources().openRawResource(R.raw.fileNameYourGoingToCopy);
String path = Environment.getExternalStorageDirectory() + "/anyFolder" + File.separator + fileNameWithExtension;
FileOutputStream out = new FileOutputStream(path);
byte[] buff = new byte[1024];
int read = 0;
try {
    while ((read = in.read(buff)) > 0) {
        out.write(buff, 0, read);
    }
} finally {
    in.close();
    out.close();
}