int counter = 1;
Button bT1 = (Button) findViewById(R.id.bT1);
bT1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        new Player(counter++,"var1FromEditText"," var2FromEditText ");
    }
});