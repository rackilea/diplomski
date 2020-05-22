MapScanCursor<String, String> scanCursor = null;

do {
    if (scanCursor == null) {
        scanCursor = redisCommands.hscan(key);
    } else {
        scanCursor = redisCommands.hscan(key, scanCursor);
    }
    fields.addAll(scanCursor.getMap().keySet());
} while (!scanCursor.isFinished());