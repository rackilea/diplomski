Button getPy = (Button) findViewById(R.id.getFilePy);
getPy.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), FileExplorer.class));
    }
});