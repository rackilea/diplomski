InputStream is = ...;
OutputStream os = ...;

byte buffer[] = new byte[1024];
int read;
while((read = is.read(buffer)) != -1){
    os.write(buffer, 0, read);
}