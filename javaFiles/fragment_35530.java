private List<String> get_files_paths(String data_path) {
    File folder = new File(data_path);
    if(!folder.exists() || !folder.isDirectory()){
        throw new IllegalArgumentException("Invalid directory");
    }
    List<String> full_paths = new ArrayList<>();
    for (File fileEntry : folder.listFiles()) {
        if (fileEntry.isFile())
            full_paths.add(fileEntry.getAbsolutePath());
    }
    return full_paths;
}