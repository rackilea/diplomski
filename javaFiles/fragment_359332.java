private void showRecord() {
    assert currentRecord >= 0 && currentRecord < records.size();
    Record record = records.get(currentRecord);
    telephoneField.setText(record.getTelephone());
    ...
}

private void previous() {
    if (currentRecord > 0) {
        currentRecord--;
        showRecord();
    }
}

private void next() {
    if (currentRecord < records.size() - 1) {
        currentRecord++;
        showRecord();
    }
}