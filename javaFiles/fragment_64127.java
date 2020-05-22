class CustomEntryBackupProcessor implements EntryBackupProcessor {

    private Object resultOfEntryProcessor;

    @Override
    public void processBackup(Map.Entry entry) {
        entry.setValue(resultOfEntryProcessor);            
    }
}