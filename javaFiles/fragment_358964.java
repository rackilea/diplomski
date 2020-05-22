Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();
User userA = (User)session.get(User.class, 1101);
transaction.commit();
session.close();
//userA is now detached as session is closed.

session = sessionFactory.openSession();
transaction = session.beginTransaction();
User userB = (User)session.get(User.class, 1101);
User userC = (User)session.merge(userA);
if (userB == userC) {
  System.out.println("Reattched user is equal");
}
transaction.commit();
session.close();