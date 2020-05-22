public void doTestButton(View v) {
    int newcolour = Color.argb(250,128,128,128);
    Intent ri = new Intent();
    ri.putExtra("BGRNDCOLOUR", newcolour);
    setResult(Activity.RESULT_OK,ri);
    finish();
}