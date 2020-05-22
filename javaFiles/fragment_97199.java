LocalDate today = LocalDate.now();
LocalDate eailer = today.minusDays(30);

Date threshold = Date.from(eailer.atStartOfDay(ZoneId.systemDefault()).toInstant());
AgeFileFilter filter = new AgeFileFilter(threshold);

File path = new File("...");
File[] oldFolders = FileFilterUtils.filter(
                FileFilterUtils.directoryFileFilter(), 
                FileFilterUtils.filter(
                                filter, 
                                path.listFiles()));

for (File folder : oldFolders) {
    System.out.println(folder);
}