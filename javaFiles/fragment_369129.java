public static void write(String output)
{
    FileWriter writer = new FileWriter(filePath, true);
    writer.write(output);
    writer.close();
}