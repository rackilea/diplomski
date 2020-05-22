// initializes a hashtable for key and value types to be String
Hashtable<String, String> h = 
              new Hashtable<String, String>();
// your string
String x = "name=josh";
// splits the string for "=" delimiter and stores in an array
String[] arrOfStr = x.split("=", 0); 
// Use the 'put' method of Hashtable to insert the 0th element of array as key and 1st element as value
h.put(arrOfStr[0],arrOfStr[1]);