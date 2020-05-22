protected void onActivityResult(int requestCode,int resultCode, Intent data) {
 super.onActivityResult(requestCode, data);

 setResult(resultCode,resultData);

 finish();
}