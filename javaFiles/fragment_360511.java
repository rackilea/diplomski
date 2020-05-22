public class GUI {

     private UserManager manager;

     public void deleteUser(User user) {
         try{
             manager.deleteUser(user);  
         }
         catch(CompanyNotExistsException e) {
             //display an error message to user
         }
     }
}

public class UserManager {

    public void deleteUser(User user) throws CompanyNotExistsException {
           if(!this.companyExists(user.getCompany()) {
               throw new CompanyNotExistsException();
           }
    }
}