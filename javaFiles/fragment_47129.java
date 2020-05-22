InputStream in = response.getEntity().getContent();
OutputStream out = context.openFileOutput("LargeImages.txt", context.MODE_PRIVATE);
byte b[] = new byte[4096];
int i;
while ((i = in.read(b)) >= 0) {
    out.write(b, 0, i);
}