public class Provider { 
    boolean gotNumber = false;
    int theNumber;
    public int getNumberofObjects() {
        if (!gotNumber) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input Number of Objects: ");
            theNumber = in.nextInt();
            gotNumber = true;
        }
        return theNumber;
    }
}