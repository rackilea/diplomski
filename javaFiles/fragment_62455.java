public class MyObjectTest {

  public static final void main(String[] args) {

   MyObject myObject = new MyObject(); 

   String theMessage = "No message yet.";

   theMessage = myObject.readSecretMessage();

   myObject.setIsSafe(true);

   theMessage = myObject.readSecretMessage();

  }
}


public class MyObject {

 private boolean isSafe = false;


 public boolean isSafe() {
    return this.isSafe;
 } 

 public boolean setIsSafe(boolean isSafe) {
   return this.isSafe = isSafe;
 }

 public String readSecretMessage() {

   if(isSafe()) {
    return "We are safe, so we can share the secret";
   }
   return "They is no secret message here.";
 }
}