public void save(Courses user) {
     try {
       Session session = sf.openSession();
       Transaction transaction = session.beginTransaction();//start transaction
       session.save(user);
       session.flush();
       transaction.commit();//commit the transaction
    } catch(Exception exe) {
      ex.printStackTrace();  
      tx.rollback();  //rollback the transaction upon exception
    } finally {
       session.close();//close the session in finally always
    }
}