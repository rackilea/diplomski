Bundle extras = getIntent().getExtras(); 
String id;

if (extras != null) {
    id= extras.getString("key");  //key should be what ever used in invoker.
}