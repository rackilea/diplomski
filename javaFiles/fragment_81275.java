User u1 = new User("a");
UserDAO.getInstance().addObject(user1); 
// UserDAO.addObject uses PersistentManager.makePersistent() in transaction and user 
// object now has its Key set. I want to avoid this step.

User u2 = new User("x"); 
u2.setKey(KeyFactory.createKey(u1.getKey(),User.class.getSimpleName(), 100 /*some random id*/)); 

User u3 = new User("p");
u3.setKey(KeyFactory.createKey(u1.getKey(), User.class.getSimpleName(), 200)); 

UserDAO.getInstance().addObjects(Arrays.asList(new User[]{u2, u3})); 
// UserDAO.addObjects uses PersistentManager.makePersistentAll() in transaction.