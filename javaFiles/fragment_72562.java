String hql = "from Users s where s.id= :userId";
List finalResult = new ArrayList();
for(int i=0; i< 10;i++){
   List result = session.createQuery(hql).setParameter("userId", i).list();
   finalResult.addCollection(result );
}