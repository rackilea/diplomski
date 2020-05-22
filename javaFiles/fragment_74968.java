User user = g.fromJson(data, User.class);

// Try this to get the token of a particular user.
// I think this may be the cause of the error.
Token token = user.getToken();

String tokenNo = token.getToken();