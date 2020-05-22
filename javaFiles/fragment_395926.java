class Test{
    private final int classSize = 35;
    private int numEnrolled, numNeeded;

    public void Input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the amount enrolled in your class");
        numEnrolled = in.nextInt();
        System.out.println("Your input is " + numEnrolled);

        // Other parts of code that needs to be coded
    }
}

public class TestRunner{
    public static void main(String args[]){
        Test newTest = new Test();
        newTest.Input();

    }}