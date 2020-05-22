//you code
//
String userCredentials = "username:password";
String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
urlc.setRequestProperty ("Authorization", basicAuth);
urlc.setRequestMethod("GET");
// your code