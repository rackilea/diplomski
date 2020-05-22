@Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   IntentResult result = IntentIntegrator.parseActivityResult(requestCode, 
   resultCode, data);
    if (result != null) {
        if (result.getContents() == null) {
         //scan have an error 
        } else {
           //scan is successful 
        }
    } else {
        super.onActivityResult(requestCode, resultCode, data);
    }
}