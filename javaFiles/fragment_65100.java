Session session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();

UnitsDao dao = (UnitsDao)new UnitsDaoImpl(session);
List<Units> unity = (List<Units>)dao.fetchAll();
Users user = unity.get(0).getUsers();
System.out.println(user);

session.getTransaction().commit();
session.close();