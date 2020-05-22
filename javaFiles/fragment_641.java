public void testSaveWithChild() {
  Child c1 = new Child("prop1", "prop2", prop3);
  Child c2 = new Child("prop4", "prop4", prop3);
  Parent p = new Parent("prop6","prop7");
  p.addChild(c1);
  p.addChild(c2);
  Session session = MysessionImplementation.getSession();
  Transaction tx = session.begingTransaction();
  ParentDAO.saveWithChild(p);
  tx.commit();

  Session session1 = MysessionImplementation.getSession();
  Parent p2 = session1.get(ParentClass.class,p.getID());
  // children from db should be in p2.getChildren()
}