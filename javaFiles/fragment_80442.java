Button btnSelectSound = (Button) findViewById (R.id.button2);
btnSelectSound.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivityForResult(new Intent(Activity1.this, Activity2.class), 1000);
    }
});