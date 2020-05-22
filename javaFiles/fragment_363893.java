JSONObject opsDictionary = new JSONObject();
    opsDictionary.put("Product","MyProduct");
    opsDictionary.put("Noun","MyNoun");
    opsDictionary.put("Verb", "MyVerb");


JSONObject authDictionary = new JSONObject(); 
    authDictionary.put("UserID","UserName");
    authDictionary.put("Password", "Password");


JSONObject postdata = new JSONObject();
postdata.put("Operation", opsDictionary);
postdata.put("Authentication", authDictionary);