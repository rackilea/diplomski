final static Migration MIGRATION_5_6 = new Migration(5, 6) {
    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {
        // Since we didn't alter the table, there's nothing else to do here.
        _db.execSQL("CREATE TABLE IF NOT EXISTS `task` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `description` TEXT NOT NULL, `priority` INTEGER NOT NULL, `updated_at` TEXT)");
    }
};