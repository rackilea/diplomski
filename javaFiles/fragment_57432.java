//create a Bundle object
Bundle extras = new Bundle();
//Adding key value pairs to this bundle
//there are quite a lot data types you can store in a bundle
extras.putString("USER_NAME","jhon Doe");
extras.putInt("USER_ID", 21);
extras.putIntArray("USER_SELCTIONS", [1, 2, 3, 4, 5]);
...
//create and initialize an intent
Intent intent = new Intent(this, NextActivity.class);
//attach the bundle to the Intent object
intent.putExtras(extras);
//finally start the activity
startActivity(intent);