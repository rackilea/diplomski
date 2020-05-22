// the Service contains the business logic and uses DAOs to access data
class BaseService {

   public Object doSomething() {
       return getDao().retrieveObject("identifier");
   }

   // Factory method producing DAOs
   public IDao getDao() {
       return new BaseDao();
   }

}

// The DAO interface
interface IDao {
    Object retrieveObject(String identifier);
}


// Another Service that overwrite the type of produced DAOs 
class SmartService extends Service {

   // overwrite the factory method
   public IDao getDao() {
       return new SmartDao();
   }
}