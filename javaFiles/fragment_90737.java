public static void main(String[] args) {
    // Get the absolute path from where your application has initialized
    File workingDirectory = new File(System.getProperty("user.dir"));
    // Get user input
    String query = new Scanner(System.in).next();
    // Perform a search in the working directory
    List<File> files = search(workingDirectory, query);
    // Check if there are no matching files
    if (files.isEmpty()) {
        System.out.println("No files found in " + workingDirectory.getPath() + " that match '"
                + query + "'");
        return;
    }
    // print all the files that matched the query
    for (File file : files) {
        System.out.println(file.getAbsolutePath());
    }
}

public static List<File> search(File file, String query) {
    List<File> fileList = new ArrayList<File>();
    // Get all the files in this directory
    File[] files = file.listFiles();
    if (files != null) {
        for (File f : files) {
            if (f.isDirectory()) {
                // use recursion to search in all directories for the file
                fileList.addAll(search(f, query));
            } else if (f.getName().toLowerCase().contains(query.toLowerCase())) {
                // if the filename matches the query, add it to the list
                fileList.add(f);
            }
        }
    }
    return fileList;
}