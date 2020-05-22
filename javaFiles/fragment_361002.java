public void addrow(View v){
   createRow();
}


public void createRow()
{
 TableRow row = new TableRow(this);
 EditText et1 = new EditText(this);
 mLayout.addView(row);
 row.addView(et1);
}