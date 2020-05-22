public  boolean alredyTakenUsername(String userna) {
   s = sessionFactory.openSession();

   try {
       String sql = "SELECT COUNT(*) FROM User where User.username= :usern";
       NativeQuery sqlQuery = s.createSQLQuery(sql);
       sqlQuery.setParameter("usern",userna);
       int numb = ((Number)sqlQuery.getSingleResult()).intValue();
       if (numb == 1)
           return true;
       else
           return false;
   } catch (Exception e){
       e.printStackTrace();
   } finally {
       s.close();
   }
   return false;
}