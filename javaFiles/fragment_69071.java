periodFromText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "WORKS!", Toast.LENGTH_SHORT).show();
                selectedTextView = (TextView) view;
                showDialog(0);
            }
        });