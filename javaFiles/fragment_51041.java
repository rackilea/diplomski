public void write(RandomAccessFile file) throws IOException
{
    for (Student s: students)
    {
        byte[] bytes = s.toString().getBytes();
        for(byte byteWrite : bytes)
        {
            file.writeByte(byteWrite);
        }
    }

}