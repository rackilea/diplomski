public int getNext (Scanner input, String prompt) {

    System.out.println (prompt);

    if (input.hasNextInt ()) {
       return input.nextInt ();
    }

    // return some magic number or maybe throw exception
    return Integer.MIN_VALUE;
}