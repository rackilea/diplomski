EditText editetext = (EditText) findViewById(R.id.editetext); // change this R.id.editetext to your EditText id
    Button doneButton = (Button) findViewById(R.id.doneButton); // change this R.id.doneButton to your Button id
            doneButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(editetext.getText.toString);
            }
        });