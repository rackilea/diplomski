private void createLayoutDynamically() {

int a = 10;
for ( int q = 1; q < a; q++) {
     myButton = new Button(this);
    myButton.setText("q:"+q);
    myButton.setId(q);

    myButton.setTag(q);
    myButton.setOnClickListener(listener);

    TableRow layout = (TableRow) findViewById(R.id.tableRow1);

    layout.addView(myButton);

}   
}