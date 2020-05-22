public byte[] getbytes(){
byte b;
b = (Byte) c; //c is a char
return new byte[]{
        (byte) 0,
        (byte) 1,
        (byte) 2,
        (byte) 5,
        (byte) b 
};