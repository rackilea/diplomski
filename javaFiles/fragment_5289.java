public int deleteCart(String userID){

    Session currentSession=sessionObject.getSession();
    Transaction tr= currentSession.beginTransaction();
    //String query="from Cart Where  userName :uName";
  try{
    String query="DELETE FROM Cart where userName = :uName";

    Query queryResult = currentSession.createQuery(query);
    queryResult.setParameter("uName", userID);

    int result = queryResult.executeUpdate();
    tr.commit();

    System.out.println("Cart delete result "+result); 

    return result;
  } catch (Exception ex) {
       tr.rollback();
       return null;
  }
}