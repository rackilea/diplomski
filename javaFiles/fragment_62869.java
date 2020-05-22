Query q = session.createQuery("from RegisterPojo where email =:email");
q.setParameter("email", "Fred@Example.com");
RegisterPojo  pojo= (RegisterPojo)q.list().get(0);

pojo.setName("Fred");
session.update(pojo);