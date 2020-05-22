Process start = Runtime.getRuntime().exec(new String[]
{ "java", "-version" });
BufferedReader r = new BufferedReader(
     new InputStreamReader(start.getErrorStream()));
String line = null;
while ((line = r.readLine()) != null)
{
    System.out.println(line);
}