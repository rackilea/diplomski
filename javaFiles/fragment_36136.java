next.setOnClickListener(new OnClickListener() { 
            @Override
            public void onClick(View v) {
        Intent intent = new Intent(SecondAcitivity.this, Aktivity.class);
        startActivity(intent);
    }});