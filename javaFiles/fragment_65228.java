String filePrefix = FileUtils.getTempDirectoryPath() + File.separator;

        URL audioURL = new URL(url);
        File destination = new File(filePrefix + UUID.randomUUID().toString());  // To store the file at a certain destination for temporary usage
        FileUtils.copyURLToFile(audioURL, destination);

        IsoFile isoFile = new IsoFile(destination.getAbsolutePath());

        double lengthInSeconds = (double)
                isoFile.getMovieBox().getMovieHeaderBox().getDuration() /
                isoFile.getMovieBox().getMovieHeaderBox().getTimescale();

        try {
            System.out.println("Length of audio in seconds === " + lengthInSeconds);
            destination.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }