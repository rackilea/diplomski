public static String ReadWholeFile(String filename) throws IOException
{
    final File file = new File(filename);
    final FileInputStream fis = new FileInputStream(file);
    final byte[] data = new byte[(int)file.length()];
    fis.read(data);
    fis.close();
    return new String(data, "UTF-8");
}