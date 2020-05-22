StringBuilder s = new StringBuilder();
    EditText et = (EditText) findViewById(EDITTEXT_ID_PATH);

    Button button_q = (Button) findViewById(BUTTON_Q_ID_PATH);
    button_q.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                s.append("q");
                et.setText(s);
            }
        });

    Button button_e = (Button) findViewById(BUTTON_E_ID_PATH);
    button_e.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                s.append("e");
                et.setText(s);
            }
        });

    Button button_w = (Button) findViewById(BUTTON_W_ID_PATH);
    button_q.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                s.append("w");
                et.setText(s);
            }
        });