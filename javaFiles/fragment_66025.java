b.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent i = new Intent(MainActivity.this, ActivityB.class);
        startActivity(i);
        }
    });