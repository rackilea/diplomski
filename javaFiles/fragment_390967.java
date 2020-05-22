public void onClick(View v) {
        if(!(displayInfo.getText().toString().equals(""))){
            compute();
            ACTION = DIVISION;
            display.setText(String.valueOf(val1) + " / ");
            displayInfo.setText("");
        }
    }