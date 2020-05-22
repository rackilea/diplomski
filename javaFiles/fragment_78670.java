Button login = (Button) findViewById(R.id.bktologin);
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(view.getContext(), Login.class);
        startActivityForResult(myIntent, 0);
        finish();
    }

});