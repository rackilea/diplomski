while (buffer.position() > 0)
{
    buffer.flip();
    int count = channel.write(buffer);
    buffer.compact();
    if (count == 0)
    {
        // see below ...
    }
}