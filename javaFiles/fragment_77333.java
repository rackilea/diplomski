File[] files = folder.listFiles(
    new FilenameFilter()
    {
        public boolean accept(final File a_directory,
                              final String a_name)
        {
            return a_name.endsWith(".jpg");
            // Or could use a regular expression:
            //
            //     return a_name.toLowerCase().matches(".*\\.(gif|jpg|png)$");
            //
        };
    });