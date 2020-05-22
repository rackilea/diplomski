mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent editScreenIntent = new Intent(ListDataActivity.this, EditDataActivity.class);
        editScreenIntent.putExtra("id",l); //<<<<<<<<<< THE ID AS kindly supplied by the CursorAdapter
        editScreenIntent.putExtra("name",data.getString(data.getColumnIndex(mDatabaseHelper.COL2)));
        editScreenIntent.putExtra("priority",data.getColumnIndex(mDatabaseHelper.COL4));
        startActivity(editScreenIntent);
        }
    }
});