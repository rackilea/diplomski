public void addOrg(Test t) {
    //System.out.println("save : "+org);
    Session session = sessionfactory.openSession();
    Transaction tx;
    try {
         tx = session.beginTransaction();
         session.save(t);
         tx.commit();
    System.out.println("after save : "+t.getAO_ID());   
    } catch (Exception e) {
       if (tx!=null) tx.rollback();
        e.printStackTrace();
    }finally {
     session.close();
     }