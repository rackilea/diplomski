String uri = request.getRequestURI ();

if (myActions.containsKey(uri)) {
   String value = myActions.get(uri);
   do something with value
} else {
   throw error message...
}