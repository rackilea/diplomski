public String preprocessing() throws IOException
{
    BufferedReader in = new BufferedReader(new FileReader("input7.txt"));
    String line = "";

      while((line = in.readLine()) != null)
        {
            System.out.println(line);
            line += line;//appending complete text
        }
     in.close();
     return line;//returning text
}