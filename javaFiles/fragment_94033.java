Session session = configuration.buildSessionFactory().openSession();
session.beginTransaction();

Parent parent = new Parent();
parent.addChild(new Child());

session.save(parent);

session.getTransaction().commit();