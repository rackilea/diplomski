//Get a list of the filenames without the filename extension
private List<String> getRawNamesOfFiles(String filenameExtension){
    List<String> fileNames = new ArrayList<String>();
    try {
        Files.walk(Paths.get("").toAbsolutePath().getParent()).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                String fileName = getRawNameOfFile(filePath, filenameExtension);
                if(fileName != null){
                    fileNames.add(fileName);
                }
            }
        });
    } catch (IOException e) {
        e.printStackTrace();
    }
    return fileNames;
}

// removes the filename extension 
// checks if the file extension of the path fits the wanted filename extension, returns null if it doesn't fit
private String checkAndEditTheName(Path path, String wantedFilenameExtension){
    int cutLength = wantedFilenameExtension.length() + (wantedFilenameExtension.startsWith(".")?0:1);
    String pathEnd = path.getFileName().toString();
    if(pathEnd != null && pathEnd.endsWith(wantedFilenameExtension)){ //search for a specific filename extension
        pathEnd = pathEnd.substring(0, pathEnd.length() - cutLength); // remove the filename extension and the point
        return pathEnd;
    }
    return null;
}