EntityManager entityManager = entityManagerProvider.get();
String qry = "UPDATE MyTable x SET x.txt=:txtParam WHERE ID=1";            
Query query = entityManager.createQuery(qry);
query.setParameter("txtParam", "123 321");

query.executeUpdate();