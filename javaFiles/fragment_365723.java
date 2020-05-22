try
{
    throw new OutOfMemoryError();
}
finally
{
    // highly discouraged too, throwing in finally shadows any throwable
    throw new RuntimeException("has something happened?");
}