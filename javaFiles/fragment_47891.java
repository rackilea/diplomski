@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE) {//same REQUEST_CODE you used in adapter

         if (resultCode == RESULT_OK) {

            //Do your thing and get the data you want.

           adapter.onDataReady(Data data);//where adapter is your recycler adapter, 
                                          //and data is whatever data you want to pass to adapter 
                                          //(Data you got from the activityResult, do not confuse it with onActivityResult's parameter 'Intent data') 
        }
    }
}