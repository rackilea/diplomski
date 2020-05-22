<% 
   Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
   Transaction tx = session2.beginTransaction();
   Query q = session2.createQuery("from Subject");
   List subjectList = q.list();
   List levelList = session2.createQuery("from Level").list(); 
%>