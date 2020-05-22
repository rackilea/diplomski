// Knows only about structure of the database (e.g. there is a table called 'user') 
// Implementation will use IDatabaseWriter to access the database
interface IDatabaseWriter {
  void createUser(User newUser);
  void updateUser(User user);
  void updateUserEmail(long userKey, Email emailInfo); 
  void updateUserCredentials(long userKey, Credential userCredentials); 
  ...
}

// Knows only about structure of the database (e.g. there is a table called 'user') 
// Implementation will use IDatabaseReader to access the database
interface IUserDatabaseReader {
  User readUser(long userKey);
  User readUser(string userName);
  Email readUserEmail(string userName);
  Credential readUserCredentials(long userKey);
  ...
}