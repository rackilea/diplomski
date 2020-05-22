// Early on
Map<String, Account> accountsByUsername = new HashMap<>();

// Then in a loop, or whatever
String username = bufferedReader.readLine();
accountsByUsername.put(username, new Account(username));