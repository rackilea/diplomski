String jsonData = "{"
   "users:[{ " +
   "name: 'Jack', " +
   "email: 'email1', " +
   "friends:[{ " +
   "    name: 'name2', " +
   "    email: 'email2', " +
   "  }] " +
   "}] " +
"}";
User[] users = gson.fromJson(jsonData, User[].class);