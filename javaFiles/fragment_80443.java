Button btnOk = (Button) findViewById (R.id.ok);
btnOk.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("soundRawId", selectedSoundRawId /* <- replace this with the selected sound, like R.raw.yourSound */);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
});