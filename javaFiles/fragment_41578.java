public void doSomething(byte[] data)
{
    for (int i=0; i < data.length; i++)
    {
        data[i] = (byte) i;
    }
}