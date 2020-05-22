public class Meny {

    @SuppressWarnings("resource")
    public static boolean meny(Scanner input, ArrayList<Integer> arrayListNumbers){

        Scanner inputMeny = new Scanner(System.in);


        System.out.println("\n What do you want to do? \n 1 : Arraylist? \n 2 : Array? \n 3 : Convert your Array to an Arraylist \n 4 : Convert your Arraylist to an Array \n 5 : Exit");

        int answer = inputMeny.nextInt();
.....