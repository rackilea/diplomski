if (f.exists())
{
    w.write("Got em coach\n");
    w.write("We need more info\n");
    w.write("Come again\n");

    // Adding this call flushes and closes the data stream.
    w.close();
}