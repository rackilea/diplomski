@Stateful   
class MyStatelessEJB {    
   // Entity Manager is automatically created and injected     
   // persistent unit name is in persistence.xml
   @PersistenceContext(unitName="myPersistenceUnitName",type=PersistenceContextType.EXTENDED)   
   EntityManager em;    
   Query q1 = null;    
   Query q2 = null;

   @NOT_SUPPORTED                                     // no transaction or PC here 
   public methodA() {....                               
                      q1 = em.createQuery(...);       // create query anyway
                      q2 = em.createTypedQuery(...);
                      ...}  

   public methodB() {....  q.execute();  ...}    // transaction & PC here - just use Query

   @Remove   
   // when this method is completes the EJB Session ends    
   public methodC() {....  List<Foo> fooList = q.execute().getResultList; ...} 

}