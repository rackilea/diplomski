private static void dumpTableToCsvFile(SQLiteDatabase db, String tableName) {
    try {
        // Query the data in the table
        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);

        File file = new File(exportDir, tableName +".csv");
        file.createNewFile();

        CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
        // Write the table data to the file
        csvWriter.writeNext(cursor.getColumnNames());
        while(cursor.moveToNext()) {
            String arrStr[] = { cursor.getString(0), cursor.getString(1) };
            csvWriter.writeNext(arrStr);
        }
        // close cursor and writer
        cursor.close();
        csvWriter.close();

    } catch (IOException e) {
        // handle exception
    }
}