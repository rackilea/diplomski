public class MultiSessionObject implements Session {

   private Session writeOnlySession;
   private Session readWriteSession;

   @Override
   public void saveOrUpdate(Object arg0) throws HibernateException {

        Transaction readWriteSessionTx = null;
        try {
            readWriteSessionTx = readWriteSession.beginTransaction();
            readWriteSession.merge(arg0);
            readWriteSessionTx.commit();
        } catch (RuntimeException e) {
            if ( readWriteSessionTx != null && readWriteSessionTx.isActive() ) 
                readWriteSessionTx.rollback();
            throw e;
        }

        Transaction writeOnlySessionTx = null;
        try {
            writeOnlySessionTx = writeOnlySession.beginTransaction();
            writeOnlySession.merge(arg0);
            writeOnlySessionTx.commit();
        } catch (RuntimeException e) {
            if ( writeOnlySessionTx != null && writeOnlySessionTx.isActive() ) 
                writeOnlySessionTx.rollback();
            throw e;
        }
   }
}