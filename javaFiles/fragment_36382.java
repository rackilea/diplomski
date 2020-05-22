for (int i=0; i < rowNumber; i++) {
  TableRow row = new TableRow(MainActivity.this);
      for (int j=0; j < columnNumber; j++) {
        int value = random.nextInt(100) + 1;
        TextView tv = new TextView(MainActivity.this);
        tv.setText(String.valueOf(value));
        row.addView(tv);
      }
  table.addView(row);
}