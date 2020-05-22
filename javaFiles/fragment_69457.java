public class MainApp 
  {
     private User userLoggedIn;

     public MainApp()
     {
         userLoggedIn = new User("john doe");
     }

     public User getUserLoggedIn()
     {
         return userLoggedIn;
     }
  }

  public class MyController 
  { 
    MainApp mainApp = new MainApp();
    mainApp.getUserLoggedIn().addNewFood(new Food(//enter datum here));
  }