public class SomeBean {

   Future<User> futureUser;


   public String doStuff() {
      futureUser = dao.getByID(someID);
      return "";
   }

   public getUser() {
      return futureUser.get(); // blocks in case result is not there
   }

}