Intent myIntent = new Intent(firstActivity.this,secondActivity.class);
Bundle muBundle = new Bundle(); //create a Bundle
myBundle.putString("username","Sherif");
myBundle.putInt("userid",1234);
// EXAMINE THE [Bundle Class][2]
myIntent.putExtras(myBundle); //PUT THE Bundle you created in the Intent
startActivityForResult(myIntent, 0);