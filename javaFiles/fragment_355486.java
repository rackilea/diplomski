@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE_EMAIL && resultCode == RESULT_OK) {
       String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
       email.setText(accountName);
    } else if(requestCode == REQUEST_CODE_EMAIL && resultCode == RESULT_CANCELED) {
      Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
    }  
}