TableLayout layout = (TableLayout) findViewById(R.id.Table_ID);
for (int i = 0; i < layout.getChildCount(); i++) {
View child = layout.getChildAt(i);

if (child instanceof TableRow) {
    TableRow row = (TableRow) child;

    for (int x = 0; x < row.getChildCount(); x++) {
        View view = row.getChildAt(x);//Here you get Your Button View

    }
}
}