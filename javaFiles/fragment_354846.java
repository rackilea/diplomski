import java.util.Scanner;

class naFam {
    static void findNa(String[] array, String[] lookupArray) {
        boolean equal = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=lookupArray[i]) {
                equal=false;
            }
        }
        if (equal==true) {
             System.out.println("NA");
        } else {
            System.out.println(array[0]);
        }
    }

    public static void main(String[] args) {
        //Create a new scanner
        Scanner scan = new Scanner(System.in);
        //Create the integer for the size of the array they want to input
        int size1;
        //Input the size
        size1 = scan.nextInt();
        //Create and input the arrays
        String[] arrayOne = new String[size1];
        String[] arrayTwo = new String[size1];

        for (int i = 0; i < size1; i++) {
            arrayOne[i] = scan.next();
        }
        for (int i = 0; i < size1; i++) {
            arrayTwo[i] = scan.next();
        }
        findNa(arrayOne,arrayTwo);
    }
}