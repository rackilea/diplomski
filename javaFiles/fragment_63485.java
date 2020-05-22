//add more items button
    Button more = (Button) findViewById(R.id.button1);
    more.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
            player = txt1.getText().toString();
            if (txt1.getText().toString().length() !=0){
                playerList.add(player);
                txt1.setText(""); 
            }
            Toast.makeText(getBaseContext(), playerList + " ",  Toast.LENGTH_LONG).show();

        }

    });