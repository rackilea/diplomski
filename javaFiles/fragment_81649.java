public FileInputStream getFileInputStream() throws FileNotFoundException
{
    File file = new File("somepath");
    FileInputStream fInputStream = new FileInputStream(file);
    return fInputStream;
}