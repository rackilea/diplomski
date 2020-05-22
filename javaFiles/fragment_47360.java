public <T extends MyDatabaseClass> List<T> getList(Class<T> clazz) {
        Cursor cursor = getCursor(clazz);
        List<T> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            //noinspection unchecked
            list.add((T) getDatabaseObjectFromCursor(clazz, cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }