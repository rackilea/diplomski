Comparator<File> nameNumberComparator = new Comparator<File>() {
    @Override
    public int compare(File f1, File f2) {
        return Integer.compare(Integer.valueOf(f1.getName()),
                Integer.valueOf(f1.getName()));
    }
};