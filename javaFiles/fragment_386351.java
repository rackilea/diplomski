public static void main(String[] args) {
    printNumbersB();
}

public static void printNumbersB(){

    Scanner input = new Scanner(System.in);
    System.out.print("Please put in: ");
    x = input.nextInt();
    //Should use String Builder
    String accumlationString = "";
    for(int y = 1; y <= x; y++){

        System.out.printf(accumulationString + "%5d",  y);
     accumulationString = accumulationString + "%5d";
;

        input.close();

    }

}
}