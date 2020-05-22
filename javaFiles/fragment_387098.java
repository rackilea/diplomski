customUser = documentSnapshot.toObject(CustomUser.class);
// send data
    Gson gson=new Gson();
    String objAsString=gson.toJson(customUser);
    Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
    intent.putExtra("data",objAsString);
    startActivity(intent);

    // get Data
    Gson gson=new Gson();
    String value=getIntent().getStringExtra("data");
    CustomUser customerData=gson.fromJson(value,CustomUser.class);