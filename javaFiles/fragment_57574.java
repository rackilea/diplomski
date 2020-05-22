// Add all necessary try/catch
InputStream is = ucmh.openStream();
OutputStream os = new BufferedOutputStream(new FileOutputStream("/tmp/TJ.chm"));
int len = 0;
byte[] buffer = new byte[8192]; // Or whichever size you prefer
while ((len = is.read(buffer)) > -1)
    os.write(buffer, 0, len);
os.close();
is.close();