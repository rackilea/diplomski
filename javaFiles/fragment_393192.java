ArrayList<Record> mArrayList = new ArrayList<Record>();
do {
    try {
        Record record = new Record();
        List<String> values = record.getValues();

        values.add(mCursor.getString(mCursor.getColumnIndex("_id")));
        ...
        mArrayList.add(record);
    } catch (Exception h) {

    }
}