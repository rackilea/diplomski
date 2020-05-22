public static void getsubdir(File file, List<String> strfileList) throws IOException
{
    File[] filelist = file.listFiles();
    System.out.println("filelist " + filelist.length);

    for (int i=0; i< filelist.length ; i++)
    {
        if(filelist[i].exists())
        {
            if(filelist[i].isFile())
            {
                file = filelist[i];
                System.out.println( " fileeach file : "+file.getAbsolutePath());
                strfileList.add(file.getAbsolutePath());
            }
            else if (filelist[i].isDirectory())
            {
                file = filelist[i];
                System.out.println( " fileeach Directory : "+file.getCanonicalPath());

                // Note: Since you want the directory first in the list, 
                // add it before the recursive call
                strfileList.add(file.getCanonicalPath().toString());
                Filedirexts.getsubdir(file, strfileList);
            }
        }
    }
}