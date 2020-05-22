private static void printReport(String filename, String str) throws Exception /* No, it doesn't. The only calls you had outside your catch-all `try` don't throw exceptions. */ {
    ErrorCheck ec           = new ErrorCheck();            // Recommend not creating this until/unless you need it
    String fileName         = "/var/Emails_log/"+filename; // VERY poor practice having two locals that only differ by the capitalization of one character in the middle (`filename` and `fileName`)
    Path filePath           = Paths.get(fileName);
    //  File file               = new File(fileName);      <== Removed, since you never use it for anything

    try {
        // Make sure the directories exist
        Files.createDirectories(filePath.getParent());  // No need for your null check, so I removed it; based on `fileName`, it will always have a parent

        // Open the file, creating it if it doesn't exist
        try (
            final BufferedWriter out = Files.newBufferedWriter(
                                            filePath,
                                            StandardCharsets.UTF_8,
                                            StandardOpenOption.CREATE,
                                            StandardOpenOption.APPEND)
        ) {
            // Write to out here
        }
    } catch (Exception e) {
        // Log-and-continue isn't generally best practice; and if you're going to do it
        ec.errorMsg("ERROR: GSW.SendEmail.Exception =>",e); // <== Um...send mail failed? This isn't sending mail, it's putting something in a file.
    }
    // Using the try-with-resources, we don't have to worry about the flush and close calls
}