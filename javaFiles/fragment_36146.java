public <T> Object get(int givenPosition)
{
    if ((givenPosition >= 1) && (givenPosition <= size))
        return contents[givenPosition - 1];

    return null;
}