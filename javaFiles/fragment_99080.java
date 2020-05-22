public void search(String param, Attr attr){
    try 
    {
      session = DaoSF.getSessionFactory().openSession();
      Criteria criteria = session.createCriteria(Foo.class);
      criteria.add(Restrictions.like(param, attr));
      dataList = criteria.list();
    } 
    catch (Exception e) {...}
  }