public String finder( String dirName)
{
    File dir = new File(dirName);
    if ( dir.isDirectory() )
    {

        String[] list = dir.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File f, String s ) 
            {
                return s.endsWith(".xml");
            }

       });

        if ( list.length > 0 )
        {
            return list[0];
        }
    }

    return "";

}