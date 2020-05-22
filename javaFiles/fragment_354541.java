private static FileTime getCreationTime(final Path path)
{
    final BasicFileAttributes attrs;
    try {
        attrs = Files.readAttributes(path, BasicFileAttributes.class);
        return attrs.creationTime();
    } catch (IOException oops) {
        throw new RuntimeException("can't read attributes from " + path, oops);
    }
}

private static final Comparator<Path> CREATION_TIME_COMPARATOR
    = new Comparator<Path>()
    {
        @Override
        public int compare(final Path o1, final Path o2)
        {
            return getCreationTime(o1).compareTo(getCreationTime(o2));
        }
    };