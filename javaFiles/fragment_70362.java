Cursor c = mDbHelper.returnAllColumns();
ArrayList<String> protein = new ArrayList<>();
while (c.moveToNext()) {
    protein.add(c.getString(c.getColumnIndexOrThrow("protein")));
}
Toast.makeText(getApplicationContext(), TextUtils.join(", ", protein), Toast.LENGTH_SHORT).show();