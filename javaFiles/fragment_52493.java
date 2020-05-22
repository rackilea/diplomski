BufferedReader in = new BufferedReader(new FileReader(file));
String line = in.readLine();
while(line != null)
{
    System.out.println(line);
    line = in.readLine();
}
in.close();