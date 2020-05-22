FileSystem fs = FileSystems.getDefault();

for (Path rootPath : fs.getRootDirectories())
{
    try
    {
        FileStore store = Files.getFileStore(rootPath);
        System.out.println(rootPath + ": " + store.type());
    }
    catch (IOException e)
    {
        System.out.println(rootPath + ": " + "<error getting store details>");
    }
}