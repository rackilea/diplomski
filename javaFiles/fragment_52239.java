Button btnrep = (Button)findViewById(R.id.button3);
btnrep.setOnClickListener(new View.onClickListener() {
    @Override
    public void onClick(View v) {
        Intent cam = new Intent(MainActivity.this, Camactivity.class);
        startActivityForResult(cam, 0); // If you need the result in MainAcivity, pass it back from camActivity
        // else, just startActivity(cam);
    }
});