@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 0) {
        if (resultCode == RESULT_OK) {
            String contents = data.getStringExtra("SCAN_RESULT");
        }
        if(resultCode == RESULT_CANCELLED){
            //handle cancel
        }
    }
}