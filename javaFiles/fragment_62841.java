Button b = (Button) findViewById(R.id.button1);

b.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        new DownloadJSON().execute();
    }
});