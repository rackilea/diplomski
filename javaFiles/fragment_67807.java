public void onResume() {
        super.onResume();



        //=============================================

        dip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 1, this.getResources().getDisplayMetrics());
        if (dip <= 0)
            dip = 1;


        TextView number = new TextView(this);
        TextView place = new TextView(this);
        TextView testScore = new TextView(this);


        number.setText("1");
        place.setText("4th");
        testScore.setText("113489");

        number.setWidth(50 * dip);
        place.setWidth(75 * dip);
        testScore.setWidth(150 * dip);

        number.setPadding(20*dip, 0, 0, 0);

        table = new TableLayout(this);
        TableRow row = new TableRow(this);
        row.addView(number);
        row.addView(place);
        row.addView(testScore);
        table.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        this.setContentView(table);
    }