E2 findE2ByE1Id(int E1Id){

String queryString="SELECT e1.e2 FROM E1 e1 WHERE e1.id=:id";

Query query = getEntityManager().createQuery(queryString).setParameter("id",E1Id);

try{
    return query.getSingleResult();

 }catch(NoResultException e){
    System.out.println("No result found");
    return null;
 }
}