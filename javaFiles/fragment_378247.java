public static List<File> getAllChildFiles(File[] dir)
{

    List<File> result = new ArrayList<File>();
    for (File file : dir)
    {
        if (file.isDirectory())
        {
            File[] children = file.listFiles();
            List<File> grandChildren = getAllChildFiles(children);
            result.addAll(grandChildren);
        }
        else
        {
            result.add(file);
        }
    }

    return result;
}