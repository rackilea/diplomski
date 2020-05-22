@Override
public void drop(DropTargetEvent event) {
    String[] fileNames = (String[]) event.data;
    for (String fileName : fileNames) {
        final File file = new File(fileName);
        if (file.isDirectory()) {
            Collection<File> subFiles = FileUtils.listFiles(file, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            for (File subFile : subFiles) {
                System.out.println(subFile.getAbsolutePath());
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }
}