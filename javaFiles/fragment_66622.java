InputStream is = new BufferedInputStream(request.openStream());
String fileName = String.valueOf(Calendar.getInstance().getTimeInMillis());
FileOutputStream fos = ctx.openFileOutput(fileName, Context.MODE_PRIVATE);
byte[] buffer = new byte[1024];
int red = 0;
while ((red = is.read(buffer)) != -1) {
    fos.write(buffer,0, red);
}
fos.close();
is.close();