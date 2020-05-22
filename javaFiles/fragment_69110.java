Scanner sc = new Scanner(System.in);
String answer = "";
boolean invalidInput = true;    
while(invalidInput){
    try {
        answer = sc.nextLine().toUpperCase();
        if (!answer.equals("A") && !answer.equals("B") && !answer.equals("C")) {
            throw new InputMismatchException();
        } 
        invalidInput = false;
    } catch (InputMismatchException e) {
        System.out.println("Enter a letter please");
        invalidInput = true;
    }
}