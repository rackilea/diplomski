BufferedReader in = new BufferedReader(new FileReader("<Filename>"));
String line;
while((line = in.readLine()) != null)
{
     txtArea.append(line);
}
in.close(

);