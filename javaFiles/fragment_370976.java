String[] readFile(String filename)
{
    String[] strings;

    BufferedReader reader = null;
    try
    {
        reader = new BufferedReader( new InputStreamReader( new FileInputStream(filename)));

        String str = reader.readLine();
        while( null != str )
        {
            strings.add(str);
            str = reader.readLine();
        }
    }
    catch( IOException e )
    {
        e.printStackTrace();
    }

    if( null != reader )
    {
        reader.close();
    }
    return strings.toArray(new String[strings.size()]);
}


void writeFile(String filename, String[] strings )
{
    PrintWriter writer = null;

    try
    {
        writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename)));

        for( int idx = 0; idx < strings.length; idx++ )
        {
            writer.println(strings[idx]);
        }
    }
    catch( IOException e )
    {
        e.printStackTrace();
    }

    if( null != writer )
    {
        writer.close();
    }

}