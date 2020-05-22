BufferedImage localImage = null;
try
{
    localImage = ImageIo.read(...);
}
catch (IOException e)
{
    // No need to set a value, given that it's already going to be null.
    // You probably want to log though.
}
connectionImage = localImage;