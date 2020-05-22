final TextView test_name = new TextView(this);
            test_name.setId(21);// define id that must be unique
            test_name.setText("Speed Test 60(min) Demo-ST-01"); // set the text for the header 
            test_name.setTextColor(Color.BLACK); // set the color
            test_name.setPadding(5,5,5,5); // set the padding (if required)
            tr_data.addView(test_name); // add the column to the table row here


 report_table.addView(tr_data, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

            tr_data.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    String test_name1= test_name.getText().toString();
                    Toast.makeText(getApplicationContext(), test_name1, Toast.LENGTH_LONG).show();
                }
            });