TableLayout l1 = (TableLayout) findViewById(R.id.table1);

for (int i = 0; i < l1.getChildCount(); i++) {
    View child = l1.getChildAt(i);

    if (child instanceof TableRow) {
        TableRow row = (TableRow) child;

        for (int x = 0; x < row.getChildCount(); x++) {
            //View view = row.getChildAt(x);
            TextView text = (TextView)row.getChildAt(x); // get child index on particular row
            String title = text.getText().toString();
            Log.i("Value", title);      
        }
    }
}