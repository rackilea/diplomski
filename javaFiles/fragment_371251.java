public static void main (String [] arsg) {
    int weight = inWeight();
    System.out.println("Average month weight is " + (weight / 12));
}

private static int inWeight() {
    int result = 0;
    for (int i=1; i<=12; i++) {
        int number = ConsoleInput.readInt("enter month weight");
        while (number <= 0) {
            System.out.println("error, try again");
            number = ConsoleInput.readInt("enter month weight");
        }
        result += number;
    }
    return result;
}