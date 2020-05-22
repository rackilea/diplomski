InputStream in; //FileInputStream 
OutputStream out; //DataOutputStream

byte[] buffer = new byte[10 * 1024]; //or anything bigger you want

int bytesRead;

while ((bytesRead = in.read(buffer, 0, buffer.length) > 0)) {
   out.write(buffer, 0, bytesRead);
}