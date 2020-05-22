BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
String line;
while ((line = reader.readLine()) != null)
{
    System.out.println(line);
}