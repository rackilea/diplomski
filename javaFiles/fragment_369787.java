private void closeDatabase() {
    if (_db != null && _db.isOpen()) {
        _db.close();
    }
}

private void openReadableDatabase() {
    _db = getReadableDatabase();
}

private void openWritableDatabase() {
    _db = getWritableDatabase();
}