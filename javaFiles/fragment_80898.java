for(int i = 0; i < Users.length; i++) {
    User aUser = Users[i];
    // Do something with user
}

Replaced with

try {
  for(int i = 0; ; i++) {
      User aUser = Users[i];
      // Do something with user
  }
}
catch(ArrayOutOfBoundException AOBE) {}