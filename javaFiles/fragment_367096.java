public class Test {
public void getQuerys(){
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("InternshipIS");
    EntityManager em = emFactory.createEntityManager();
    String sqlQuery = "SELECT * FROM Employee";
    Query q =   em.createNativeQuery(sqlQuery); 
 }
}