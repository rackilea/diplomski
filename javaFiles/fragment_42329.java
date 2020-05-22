public class Apples {
    public static void main(String args[]){
        Scanner icecub = new Scanner(System.in);

        String passln = "Please enter the correct password: ";
        String passwd = "testpass";
        String userpw;

        System.out.print(passln);
        userpw = icecub.next();

        if(userpw.equals(passwd)){
            System.out.println("The password is correct!");
        } else {
            System.out.println(userpw);
            System.out.println("Incorrect password!");
        }
    }
}