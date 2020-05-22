public class Start {
    public Register theReg = new Register(); //<<---- your global var
    public static Start go = new Start();

    public static void main(String[] args) {
        Register theReg = new Register();  // <<---- hiding the global
        go.regUsers();

        if(theReg.logIn("jsmith","password")) 
          System.out.println("You're logged in as " + theReg.userLoggedIn.getName());
        else 
          System.out.println("dang");
    }
}