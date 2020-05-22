public void addrow(View v){ // see it takes view as param.
    TableRow row = new TableRow(this);
    EditText et1 = new EditText(this);
    mLayout.addView(row);
    row.addView(et1);
}