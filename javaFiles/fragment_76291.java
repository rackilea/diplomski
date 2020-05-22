Files.walkFileTree(dirs, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path file,
                    BasicFileAttributes attrs) {

                DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
                    @Override
                    public boolean accept(Path entry) throws IOException {
                        BasicFileAttributes attr = Files.readAttributes(entry,
                                BasicFileAttributes.class);
                        FileTime creationTime = attr.creationTime();
                        Calendar cal = Calendar.getInstance();
                        int days = cal.fieldDifference(
                                new Date(creationTime.toMillis()),
                                Calendar.DAY_OF_YEAR);
                        return (Math.abs(days) > 60);
                    }
                };
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(
                        file, filter)) {
                    for (Path path : stream) {
                        System.out.println(path.toString());
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return FileVisitResult.CONTINUE;

            }
        });