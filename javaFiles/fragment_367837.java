public void onBackPressed() {
    Intent moveView = getIntent();
    //Here your can add whatever values you want to send back to your activity
    moveView.putExtra("some_key",value)
    setResult(Activity.RESULT_OK,moveView);
    finish();
}