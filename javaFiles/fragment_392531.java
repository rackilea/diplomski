public final class MyFilter
    implements DirectoryStream.Filter<Path>
{
    // Now minus 30 seconds
    private final FileTime timestamp
        = FileTime.fromMillis(System.currentTimeMillis() - 30_000);
    private int counter;

    public MyFilter(final int initialCounter)
    {
        counter = initialCounter;
    }

    @Override
    public boolean accept(final Path entry)
    {
        counter--;

        if (!Files.isRegularFile(entry))
            return false;
        if (Files.getLastModifiedTime(entry).compareTo(timestamp) >= 0)
            return false;

        return counter > 0;
    }
}