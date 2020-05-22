Set<String> ids = new HashSet<>();

void processRecord(Record record) {
    if (record.hasFlag()) {
        if (!ids.add(record.getId())) {
            alertDuplicate(record);
        }
    } else {
        ids.remove(record.getId());
    }
}