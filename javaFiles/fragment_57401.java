public void addRow(ScheduledRecord r) {
    if (scheduledRecords.contains(r)) {
        throw new IllegalArgumentException("Scheduled Record " + r.toString() + " already exists");
    }
    scheduledRecords.add(r);
}