for(Iterator<Integer> iter = id.iterator(); iter.hasNext();) {
    Integer currentID = iter.next();
    System.out.println("id: "+ currentID); 
    Query query = session.createQuery("update MyTable set url =? where id=?);
    query.setParameter(0,url);
    query.setParameter(1,currentID);
    query.executeUpdate();
}