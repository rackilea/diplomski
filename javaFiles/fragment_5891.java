private Map<File, List<File>> getAllFiles(List<File> files) {
    return AppStorage.getInstance().getApplicationBean().getInputFilesWithTskFile()
            .entrySet()
            .stream()
            .filter(e -> files.contains(e.getKey()))
            .collect(groupingBy(Entry::getValue, mapping(Entry::getKey, toList())));
}