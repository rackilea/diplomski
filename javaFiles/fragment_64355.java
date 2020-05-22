private static boolean isValid(String strAnswer) {
    boolean valid = strAnswer.equals("A") || strAnswer.equals("B");
    if(!valid){
        System.out.println("\nInput is not valid, please enter a valid choice - A or B");
    }
    return valid;
}