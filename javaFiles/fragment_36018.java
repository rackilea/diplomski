/**
* Client program for the "Hello, world!" example.
* @param argv The command line arguments which are ignored.
*/
public static void main (String[] argv) {
try {
  HelloInterface hello = 
    (HelloInterface) Naming.lookup ("//ortles.ccs.neu.edu/Hello");   //see here the address of the server hosting the Server file,you can omit port number,it'll take default port 1099.
  System.out.println (hello.say());
 } catch (Exception e) {
  System.out.println ("HelloClient exception: " + e);
 }
}