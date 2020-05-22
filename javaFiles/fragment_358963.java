Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();
User userA = (User)session.get(User.class, 1101);
transaction.commit();
session.close();
// Since session is closed, userA is detached.

session = sessionFactory.openSession();
transaction = session.beginTransaction();
User userB = (User)session.get(User.class, 1101);
//Now here,  userB represents the same persistent row as userA.
//When an attempt to reattach userA occurs, an exception is thrown
session.update(userA);
transaction.commit();
session.close();