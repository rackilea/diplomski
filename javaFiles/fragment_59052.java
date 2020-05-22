//The buffered reader has a method readLine() that reads an entire line from the file, InputStreamReader is a reader that reads from a stream.
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//This is the StringBuilder that we will add the lines to:
StringBuilder sb = new StringBuilder(512);
String line;
//While we can read a line, append it to the StringBuilder:
while((line = reader.readLine()) != null){
    sb.append(line);
}
//Close the stream:
reader.close();
//and return the result:
return sb.toString();