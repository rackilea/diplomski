public static List<File> iterateOverFiles(File[] files) {
    List<File> result = new ArrayList<>();
    for (File file : files) {
        if (file.isDirectory()) {
            result.addAll(iterateOverFiles(file.listFiles()); // Here!
        } else {
            fileLocation = findFileswithTxtExtension(file);
            if(fileLocation != null) {
                result.add(fileLocation);
            }
        }
    }

    return result;
}