@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK) {

        String _code = data.getStringExtra("SCAN_RESULT");

        // do whatever you want

    }

}