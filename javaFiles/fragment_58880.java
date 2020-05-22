public class AppTest {
  public static void main(String[] args) {
    AppUser user = new AppUser();
    user.login();
    user.sendEmail();      
    user.logOut();  
    }
}


/** Second class **/
public class AppUser {  
   private AppMenu am;
   private EmailPage email;

   public AppUser(){
     am = new AppMenu();
     email = new EmailPage();
   }

   public void login(){
     am.login();
   }

   public void logout(){
     am.logout();
   }

   public void sendEmail(){
      email.sendEmail();
   }


}


/** Third class **/
public class AppMenu {      
  public void login() {
    System.out.println("I logged in!!!");
  }

  public void logOut() {
    System.out.println("I logged out!!!");
  }
}


/** Fourth class **/
public class EmailPage {   
    public void sendEmail() {
      System.out.println("Send Email"); 
    }

}