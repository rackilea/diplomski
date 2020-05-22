Session session = HibernateUtil.getSessionFactory().getCurrentSession();
session.beginTransaction();
Query query = session.createQuery("from DBUser where id=1");
    for(Iterator it=query.iterate();it.hasNext();){
    DBUser row = (DBUser) it.next();
    System.out.println("ID: " + row.getId());
    System.out.println("Name: " + row.getName());
    System.out.println("Amount: " + row.getAmount());
}