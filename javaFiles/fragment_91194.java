public class LoginForm extends XFormBase { 
    private String title; 

    public void setTitle(String titleValue ) { 
       this.title= titleValue; 
       System.out.println(" Form set"+this.title); 
    } 

    public String getTitle() { 
       System.out.println(" Form get"+this.title); 
       return this.title; 
   } 
}