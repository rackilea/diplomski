public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        //THIS IS A PART WHERE I NEED HELP!
        Bundle bundle = new Bundle();
        bundle.putString("name", cursor.getString(cursor.getColumnIndex(DB2.COLUMN_TXT));
        bundle.putString("number", cursor.getString(cursor.getColumnIndex(DB2.COLUMN_NMB));
        Intent intent = new Intent(TEST4.this,TEST6.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
});