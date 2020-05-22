@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
       String myValue = data.getExtras().getString("Mykey");
         Log.d(TAG,"My Value == "+myValue); //Handles your values here and views won't be null       

        }
    }