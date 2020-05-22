ScanIterator<KeyValue<String, String>> iterator = ScanIterator.hscan(redisCommands, key);

while (iterator.hasNext()) {

    KeyValue<String, String> next = iterator.next();
    // …
}