protected String doInBackground(String... args){
   MyRequests request = new MyRequest();
   jsonObject = request.loginRequest(username,password);

   //handle json object here




return null;
}