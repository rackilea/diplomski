PersistenceManager pm = JDO.factory.getPersistenceManager();

Query query = pm.newQuery(User.class, "username.toUpperCase() == usernameParam");
query.declareParameters("String usernameParam");

List<User> results = (List<User>) query.execute(username.toUpperCase());