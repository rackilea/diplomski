private static void printReport(String filename, String str) {
    try {
        Path filePath           = Paths.get("/var/Emails_log/" + filename);

        // Make sure the directories exist
        Files.createDirectories(filePath.getParent());

        // Open the file, creating it if it doesn't exist
        try (
            final BufferedWriter out = Files.newBufferedWriter(
                                            filePath,
                                            StandardCharsets.UTF_8,
                                            StandardOpenOption.CREATE,
                                            StandardOpenOption.APPEND)
        ) {
            // Write to out here, perhaps outputting `str`?
        }
    }
    catch (Exception e) {
        new ErrorCheck().errorMsg("ERROR: GSW.SendEmail.Exception =>", e); // <== But surely this message is suspect? I don't see anything sending email here.
    }
}