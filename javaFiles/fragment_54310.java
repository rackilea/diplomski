if(username.getText().toString().equals("amirul") && 
  password.getText().toString().equals("aswa")){
  Toast.makeText(getApplicationContext(), "Redirecting...", 
  Toast.LENGTH_SHORT).show();

   Intent startCamIntent = new Intent(this, Camera.class);
    startActivity(startCamIntent);
 }