PrintWriter out = null;
try
{
    FileWriter outFile = new FileWriter(p_file_path,true);
    out = new PrintWriter(outFile);
    out.println(p_data);
}
finally
{
    if (out != null)
        out.close();
}