public T get(int givenPosition)
{
    if ((givenPosition >= 1) && (givenPosition <= size))
        return (T) contents[givenPosition - 1];  // Add cast

    return null;
}