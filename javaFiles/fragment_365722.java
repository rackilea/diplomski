try
{
    throw new OutOfMemoryError();
}
finally
{
    // highly discouraged, return from finally discards any throwable
    return;
}