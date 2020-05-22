private void setupTableLayout(int NumberOfRows, int NumberOfButtons){
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(0, android.widget.TableRow.LayoutParams.MATCH_PARENT, 3f);


        TableLayout tableLayout = (TableLayout) findViewById(R.id.thetablelayout);
        tableLayout.removeAllViews();

        for (int i = 0; i < NumberOfRows; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(tableParams);

            RelativeLayout btnOneLayout = (RelativeLayout)getLayoutInflater().inflate(R.layout.custom_button, null);
            RelativeLayout btnTwoLayout = (RelativeLayout)getLayoutInflater().inflate(R.layout.custom_button, null);

            ProgressBar btnOneProgressBar = (ProgressBar)btnOneLayout.findViewById(R.id.progressBar);
            ProgressBar btnTwoProgressBar = (ProgressBar)btnTwoLayout.findViewById(R.id.progressBar);

            Button btnOne = (Button)btnOneLayout.findViewById(R.id.button);
            btnOne.setText("Btn 1, Row " + i);
            btnOne.setId(1001 + i);
            Button btnTwo = (Button)btnTwoLayout.findViewById(R.id.button);
            btnTwo.setText("Btn 2, Row " + i);
            btnTwo.setId(2001 + i);

/*            btnOne.setLayoutParams(rowParams);   //Weight for width set in Layout file on RelativeLayout
            btnTwo.setLayoutParams(rowParams);*/

            setButtonClickListener(btnOneLayout, btnOneProgressBar);
            setButtonLongClickListener(btnOneLayout, btnOneProgressBar);

            tableRow.addView(btnOneLayout); //Add layout, instead of just Button

            //Is this done as an invisible separator? You can instead just use Margin on above/below views
            View adivider = new View(this);
            adivider.setLayoutParams(new TableRow.LayoutParams(20, TableRow.LayoutParams.MATCH_PARENT));
            adivider.setBackgroundColor(Color.TRANSPARENT);

            // This bit of code deals with odd/even numbers of buttons.
            if (((i + 1) * 2) < NumberOfButtons + 1) {
                tableRow.addView(adivider);
                tableRow.addView(btnTwoLayout);

                //Click listeners
                setButtonClickListener(btnTwoLayout, btnTwoProgressBar);
                setButtonLongClickListener(btnTwoLayout, btnTwoProgressBar);

/*                btnTwo.setTextSize(14);              //If true for all buttons, can be done in Layout file
                btnTwo.setSingleLine(true);
                btnTwo.setTextColor(0xFFFFFFFF);*/

                //btnTwo.setText(getButtonName((i * 2) + 1));
                //btnTwo.setBackgroundResource(R.drawable.buttonright); //I didn't have this drawable
            } else {
                tableRow.addView(adivider);

                btnTwoLayout.setBackgroundResource(android.R.color.transparent); //I changed this to overall layout, not sure if this is what you want
                //btnTwoLayout.setVisibility(View.INVISIBLE); //Or View.GONE   //Perhaps you want this instead

                tableRow.addView(btnTwoLayout);
            }

            //Is this done as an invisible separator? You can instead just use Margin/Padding on above/below views
            View aline3 = new View(this);
            aline3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 20));
            aline3.setBackgroundColor(Color.TRANSPARENT);

            tableLayout.addView(tableRow);
            tableLayout.addView(aline3);
        }

    }

    private String getButtonName(int position){
        String name = "";
        switch (position){
            case 0:
                name = "Bob";
                break;
            case 1:
                name = "Jim";
                break;
            default:
                name = "Default";
                break;
        }
        return name;
    }

    private void setButtonClickListener(RelativeLayout layout, final ProgressBar progressBar){
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do something
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
    private void setButtonLongClickListener(RelativeLayout layout, final ProgressBar progressBar){
        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Do something
                progressBar.setVisibility(View.GONE);
                return true;
            }
        });
    }