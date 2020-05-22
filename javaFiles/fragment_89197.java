// Write data
String str="foo";
byte[] data=str.getBytes("UTF-8");
out.writeInt(data.length);
out.write(data);

// Read data
int length=in.readInt();
byte[] data=new byte[length];
in.readFully(data);
String str=new String(data,"UTF-8");