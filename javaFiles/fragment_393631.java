void deleteStudent(String deleteLine)
{
    ....
    String line;
    while((line = reader.readLine()) != null)
    {
        if (!line.equals(deleteLine))
        {
            pw.printline(line);
        }
    }
    pw.close();
}