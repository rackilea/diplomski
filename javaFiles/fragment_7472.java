byte[] readBytes(string filepath)
{
    File file = new File(filepath);
    FileInputStream stream = new FileInputStream(file);
    // create buffer of the correct size
    byte[] buffer = new byte[file.length()];
    // read in the data
    stream.read(buffer);
    return buffer;
}