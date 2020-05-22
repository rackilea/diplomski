while(line != null)
{
    String[] columns = line.split(FIELD_SEP);
    if (columns.length > 2)
    {
        String name = columns[0];
        String emailAddress = columns[1];
        String phoneNumber = columns[2];

        entriesString += padWithSpaces(name, COL_WIDTH) +
                           padWithSpaces(emailAddress, COL_WIDTH) +
                           padWithSpaces(phoneNumber, COL_WIDTH) +
                           "\n";
    }
    line = in.readLine();
}