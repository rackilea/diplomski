public List<List<FileInfo>> partition(List<FileInfo> list, int maxSize) {
    List<List<FileInfo>> result = new ArrayList<>();
    List<FileInfo> current = new ArrayList<>();
    int currentSize = 0;
    for (FileInfo fi: list) {
        if (fi.getFileSize() > 0) {
            if (!current.isEmpty()
                    && currentSize + fi.getFileSize() > maxSize) {
                result.add(current);
                current = new ArrayList<>();
                currentSize = 0;
            }
            current.add(fi);
            currentSize += fi.getFileSize();
        }
    }
    if (!current.isEmpty()) {
        result.add(current);
    }
    return result;
}