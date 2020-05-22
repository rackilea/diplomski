public static void main(String[] args)
{
    int myInt = 0;
    Scanner kb = new Scanner(System.in);
    System.out.println("Please enter a number: ");
    myInt = kb.nextInt();
    boolean isPrime = true;
        for (int i = 2; i < myInt; i++) { // exclude 1 and the variable num from the diviso
            if (myInt % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "Prime" : "Non-Prime");
}