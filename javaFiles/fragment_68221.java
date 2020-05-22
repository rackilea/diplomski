Session session = sessionFactory1.openSession();
Transaction tx = session.beginTransaction();
Item item = (Item) session.get(Item.class, new Long(1234));
tx.commit();
session.close(); // end of first session, item is detached

item.getId(); // The database identity is "1234"
item.setDescription("my new description");
Session session2 = sessionFactory.openSession();
Transaction tx2 = session2.beginTransaction();
Item item2 = (Item) session2.get(Item.class, new Long(1234));
Item item3 = session2.merge(item); // Success!
tx2.commit();
session2.close();