List<String> lines = new ArrayList<String>();
BufferedReader in = new BufferedReader(new FileReader("wordlist.txt"));
String line = null;
while (null!=(line=in.readLine()))
{
   lines.add(line);
}
in.close();