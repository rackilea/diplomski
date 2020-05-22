File dir = new File("directoryName");
if(dir.isDirectory())
{
    File filesList[] = dir.listFiles();

    for(int i = 0; i < filesList.length; i++)
    {
        //do your processing here
    }
}