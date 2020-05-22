public static TestObject deserialize(byte[] data, int offset, int length)
{
    try
    {
        ObjectInputStream iStream = new ObjectInputStream(
                new ByteArrayInputStream(data, offset, length));
        // etc ...
}