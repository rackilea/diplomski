setContentView(R.layout.your_activity);
Button DeclineBtn = (Button) findViewById(R.id.declineBTN);
DeclineBtn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        Log.d(LOGTAG, "button clicked NICE!!!");
    }
});