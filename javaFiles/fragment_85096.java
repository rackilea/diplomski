public static float floatInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input a float:");
    for(;;){
        try{
            return Float.parseFloat(scanner.next());
        } catch(NumberFormatException e){
            System.out.println("Incorrect input type, try again:");
        }
    }
}