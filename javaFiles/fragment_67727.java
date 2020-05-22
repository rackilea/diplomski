LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();

  // Call Back method  to get the Message form other Activity
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    // check if the request code is same as what is passed  here it is 2
    if (requestCode == 2 && data!=null) {
        String message = data.getStringExtra(SCAN_RESULT);
       if(message!= null){
            Log.e("SCAN_RESULT", "" + message);
            showBarCodeContentDialoig(message);
            storeScanValue(scanResult);
        }
    }
}