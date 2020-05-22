public class bear{
   public static void main(String[] args){
     Scanner Bugs = new Scanner(System.in);
     System.out.println("Please enter your name");
     pee obj1 = new pee();
     String Name = Bugs.nextLine();
     obj1.PrintMessage(Name);
     Bugs.close();
   } 
}