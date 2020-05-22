while (position < size) {
    long count = inChannel.transferTo(position, size, outChannel);
    if (count > 0)
    {
        position += count;
        size-= count;
    }
}