Button getPy = (Button) findViewById(R.id.getFilePy);
OnClickListener pyList = new OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, FileExplorer.class));
    }
};
getPy.setOnClickListener(pyList);