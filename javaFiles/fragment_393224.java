while (true)
{
    int length = input.readInt();
    byte[] buffer = new byte[length];
    input.readFully(buffer, 0, length);
    // Process buffer
}