public StringBuffer readFile()
{
    StringBuffer tempSB = new StringBuffer();

    try
    {
        FileReader file = new FileReader(FILE_LOCATION);
        BR = new BufferedReader(file);
        String strLine = null;

        while((strLine = BR.readLine()) != null)
        {
            tempSB.append(strLine);
            tempSB.append("\n");
        }
    }
    catch(Exception e)
    {

    }

    return temp;
}