List<String> values = new ArrayList<String>();
values.add("A");
values.add("B");
values.add("C");
values.add("D");
values.add("E");
values.add("D");

BufferedWriter fileWriter = null;
try
{
    fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileName.txt")));

    for (String value : values)
    {
        fileWriter.write(value + System.getProperty("line.separator"));
    }
}
finally
{
    if (fileWriter != null)
        fileWriter.close();
}