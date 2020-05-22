final FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("N/A", "pdf", "csv"//, whatever other extensions you want);
final File file = new File("whatever");
for (final File child : file.listFiles()) {
    if(extensionFilter.accept(child)) {
        //do stuff
    }
}