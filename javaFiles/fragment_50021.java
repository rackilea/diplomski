int correctAnswers=0;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String firstname =keyboard.nextLine();
    System.out.println("Welcome "+ firstname+  "!"+ " Please answer the following questions:");
    int totalAnswers=4;
    for (int i=0;i<totalAnswers;i++) {
        int x =  (int)(20 * Math.random()) + 1;
        int y =  (int)(20 * Math.random()) + 1;

        int sum = (x+y);
        System.out.println(x + " + " + y + " = ");
        String sInput = keyboard.nextLine();
        int answer1 = Integer.parseInt(sInput);
        if (answer1 ==sum){
            System.out.println("Correct!");
            correctAnswers++;
        }
        else{
            System.out.println("Wrong!");
            System.out.println("The correct answer is " +sum);     
        }
    }
    System.out.println("Correct answers: "+ correctAnswers + "("+correctAnswers*100/totalAnswers+"%)");