OutputStream dos = new FileOutputStream("c:\\testtttt.jpg");
int count;
byte[] buffer = new byte[2048];
boolean eohFound = false;
while ((count = in.read(buffer)) != -1)
{
    if(!eohFound){
        String string = new String(buffer, 0, count);
        int indexOfEOH = string.indexOf("\r\n\r\n");
        if(indexOfEOH != -1) {
            count = count-indexOfEOH-4;
            buffer = string.substring(indexOfEOH+4).getBytes();
            eohFound = true;
        } else {
            count = 0;
        }
    }
  dos.write(buffer, 0, count);
  dos.flush();
}
in.close();
dos.close();