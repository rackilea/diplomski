text_box2 = (EditText) findViewById(R.id.fillingPressure);
        input2 = String.valueOf(text_box2.getText());
        text_box2.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((hasFocus)&&(input2.equals("0.0") || input2.equals(""))) {
                        text_box2.setText("");
                }
                input2 = (String.valueOf(text_box2.getText()));
                if ((!hasFocus) && (input2.equals(""))){
                    text_box2.setText("0.0");
                }
            }
        });

        text_box1 = (EditText) findViewById(R.id.tankVolume);
        input1 = String.valueOf(text_box1.getText());
        text_box1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((hasFocus)&&(input1.equals("0.0") || input1.equals(""))) {
                    text_box1.setText("");
                }
                input1 = (String.valueOf(text_box1.getText()));
                if ((!hasFocus) && (input1.equals(""))){
                    text_box1.setText("0.0");
                }

            }
        });