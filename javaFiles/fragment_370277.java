FileInputStream fin;
fin = new FileInputStream("file.txt");
DataInputStream in = new DataInputStream (fin);
BufferedReader br = new BufferedReader (new InputStreamReader (in));
List<String> list = new ArrayList<String>();
String line;
while ((line= br.readLine())!=null)
{
  list.add(line);  
}