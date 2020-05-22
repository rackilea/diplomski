BufferReader in=new BufferedReader...
String line;
while ((line=in.readLine())!=null) {
  String[] data=line.split(" ");
  //now, data will be a array which contains the data
  //data[0] = the first item in the line
  //data[1] = the first number
  //data[2] = the second number
}