viewBtn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        number = 5; //this is an integer
        Intent in = new Intent(FirstActivity.this, SecondActivity.class);
        in.putExtra("name of your value (eg. adapter_int)", number);
        startActivity(in);
    }
});