private Map<File, List<File>> getAllFiles(List<File> files) {
    final Set<File> filter = Set.copyOf(files);
    return AppStorage.getInstance().getApplicationBean().getInputFilesWithTskFile()
            .entrySet()
            .stream()
            .filter(e -> filter.contains(e.getKey()))
            .collect(groupingBy(Entry::getValue, mapping(Entry::getKey, toList())));
}