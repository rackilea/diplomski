GridLayout gridLayout = new GridLayout(this);
gridLayout.setColumnCount(colCount);
gridLayout.setRowCount(rowCount);

GridLayout.LayoutParams third = new GridLayout.LayoutParams(0, 0);
textView1.setLayoutParams(third);
gridLayout.addView(textView1, third);

GridLayout.LayoutParams fourth = new GridLayout.LayoutParams(0, 1);
cb.setLayoutParams(fourth);
gridLayout.addView(cb, fourth);

GridLayout.LayoutParams fifth = new GridLayout.LayoutParams(0, 2);
textView2.setLayoutParams(fifth );
gridLayout.addView(textView2, fifth);