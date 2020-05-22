DataInputStream inStream = null; 
inStream = new DataInputStream(new BufferedInputStream(newFileInputStream(file)));

int c = -1;
while((c = inStream.read()) != -1){
    Byte b = new Byte();
    b.readInt(c);
    System.out.println( c +":" + b.toString());
}