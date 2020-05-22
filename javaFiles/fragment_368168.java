HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.connect();

// get the response code, returns 200 if it's OK
int responseCode = connection.getResponseCode();

if(responseCode == 200) {
    // response code is OK
    in = connection.getInputStream();
}else{
    // response code is not OK
}