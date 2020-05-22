DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
    @Override
    public boolean accept(Path entry) throws IOException {BasicFileAttributes attr = Files.readAttributes(entry,BasicFileAttributes.class);
    FileTime creationTime = attr.creationTime();
    Calendar cal = Calendar.getInstance();
    int days = cal.fieldDifference(new Date(creationTime.toMillis()),Calendar.DAY_OF_YEAR);
        return (Math.abs(days) > 60);
        }
  };