class CDR {
    private final String fileName;
    private final List<CDREntry> entries;

    public CDR(String fileName, List<CDREntry> entries) {
        this.fileName = fileName;
        this.entries = entries;
    }

    public List<CDREntry> getEntries() {
        return entries;
    }

    public String getFileName() {
        return this.fileName;
    }
}