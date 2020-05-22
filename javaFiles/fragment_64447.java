try
{
    while (reader.hasNextLine())
    {
        if (reader.hasNext("A")) {
            handleAdd(reader);
        } else if (reader.hasNext("X")) {
            handleCancel(reader);
        } else if (reader.hasNext("D")) {
            handleDelete(reader);
        } else if (reader.hasNext("E")) {
            handleExecute(reader);
        } else if (reader.hasNext("R")) {
            handleReplace(reader);
        } else {
            // unexpected token. pretty sure this is the case that triggers your exeception. 
            // basically log as info and ignore.
            reader.nextLine();
        }
    } 
}
finally
{
    reader.close();
}