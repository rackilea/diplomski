JSONObject resultObject = new JSONObject();
JSONObject usersObject = new JSONObject();

JSONObject user1 = new JSONObject();
user1.put("Name", "Amit");
user1.put("Age", "32");
user1.put("Gender", "Male");
user1.put("Hobby", "Cricket");

usersObject.put("user-1", user1);

// repeat for user 2, 3, 4, ...

resultObject.put("users", usersObject);