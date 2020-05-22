private static String readFile(String file) throws IOException
{
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line=null;
    StringBuilder stringBuilder = new StringBuilder();
    String is=System.getProperty("line.seperator");

    while((line=reader.readLine())!=null)
    {
        stringBuilder.append(line);
        stringBuilder.append(is);
    }

    return stringBuilder.toString();
}