public static void main(String[] args) throws Exception
{
    BufferedReader inChannel = new BufferedReader(new FileReader("C:/script.txt"));
    BufferedWriter outChannel = new BufferedWriter(new FileWriter("C:/output.txt"));
    String toParse = "";
    while ( (toParse = inChannel.readLine()) != null )
    {
        String toWrite = "";
        for(int i=0; i!=toParse.length();i++)
        {
            char c = toParse.charAt(i);
            if(true) //check if must be encoded or not
            {
                c++;
                toWrite += c;
            }
        }
        outChannel.write(toWrite);
        outChannel.newLine();
    }       
    inChannel.close();
    outChannel.close();
}