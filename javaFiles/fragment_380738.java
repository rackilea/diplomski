public class Email {


Email(final String from,final String pwd,String to,String sub,String msg){
....

  Authenticator a=new Authenticator() {
protected PasswordAuthentication getPasswordAuthentication()
      {
         return new PasswordAuthentication(from,pwd); 
      }
 };
 ...

}