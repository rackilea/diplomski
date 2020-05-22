mListView.setOnItemClickListener(new OnItemClickListener() {
    public void onItemClick(AdapterView<?> a, View v, final int position, long id) {
    AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
    adb.setTitle("Delete?");
    adb.setMessage("Are you sure you want to delete this note?");
    final int positionToRemove = position;
    adb.setNegativeButton("Cancel", null);
    adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            db.delete(InputContract.TaskEntry.TABLE, InputContract.TaskEntry._ID + " = ?", new String[] { String.valueOf(positionToRemove)});
            list.remove(positionToRemove);
            adapter.notifyDataSetChanged();
        }});

    deleteTask();
    adb.show();
    }
});