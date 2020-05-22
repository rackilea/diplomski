btnCheck.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // setContentView(R.layout.activity_main); // This is not the way for starting another activity 

        Intent intent = new Intent(this, MainActivity.class); 
        startActivity(intent);
    }
});