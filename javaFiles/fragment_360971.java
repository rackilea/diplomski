Session s = factory.getCurrentSession();
try {
  s.beginTransaction();
  Thing thing = new Thing();
  s.save(thing);
  s.getTransaction().commit();
} catch (RuntimeException e) {
  s.getTransaction().rollback();
  throw e;
}