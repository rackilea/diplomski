TextView text = new TextView(MyClass.this);
text.setText(someString);
text.setTextSize(15);
text.setTextColor(Color.parseColor("#FF9900"));
text.setLayoutParams(new TableRow.LayoutParams
        (LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));


//Prepare TableRow to be inserted
TableRow row = new TableRow(MyClass.this);
row.addView(text);
row.setPadding(4,4,4,4);
row.setGravity(Gravity.CENTER);
row.setLayoutParams(new TableLayout.LayoutParams
        (LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

//add row to the table
someTableLayout.addView(row);