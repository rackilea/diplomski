public class TestArraylist {
   static NewClass newClass = new NewClass(); 
 ---------
 --------
     public static void menu(){

            case 1:
                ArrayList<String> l2c = newClass.getL2c(); //this way you can access the data
                System.out.println("How many:");
                how_many = keyboard.nextInt();keyboard.nextLine();
                for (int i=0;i<how_many;i++){
                System.out.println("Insert values:");
                l2c.add(keyboard.nextLine()); //here you need only the instance variable to add the data into the arraylist.
                System.out.println("values:"+l2c.toString()); //to print the data
                }
                break;
    //Same way you should modify the case2 as well.
            case 2:

                ArrayList<String> r2p = newClass.getR2p();
                System.out.println("How many:");
                how_many = keyboard.nextInt();keyboard.nextLine();
                for (int i=0;i<how_many;i++){
                System.out.println("Insert values:");
                r2p.add(keyboard.nextLine());
                System.out.println("values:"+r2p.toString());
                }
                break;