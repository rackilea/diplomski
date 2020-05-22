TransactionTemplate transactionTemplate=new TransactionTemplate();
transactionTemplate.execute(new TransactionCallback() {
    @Override
    public Object doInTransaction(TransactionStatus status) {
    int deleteStatus = 0;
        try {
   final String deleteQuery = "delete from tablename where name='" + name + "'";
   deleteStatus = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
   public Object doInHibernate(final Session session) throws HibernateException, java.sql.SQLException {
   Query query = session.createSQLQuery(deleteQuery);
   return query.executeUpdate();
         }
     });
 if (deleteStatus > 0) {
       file.delete();
        }
 } catch (Exception e) {
    e.printStackTrace();
       }
     return deleteStatus;
  }
});