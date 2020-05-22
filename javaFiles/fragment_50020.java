ArrayList<String> correctAnswers = new ArrayList<String>();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String firstname =keyboard.nextLine();
    System.out.println("Welcome "+ firstname+  "!"+ " Please answer the following questions:");
    for (int i=0;i<10;i++) {
        int x =  (int)(20 * Math.random()) + 1;
        int y =  (int)(20 * Math.random()) + 1;

        int sum = (x+y);
        System.out.println(x + " + " + y + " = ");
        String sInput = keyboard.nextLine();
        int answer1 = Integer.parseInt(sInput);
        if (answer1 ==sum){
            System.out.println("Correct!");
            correctAnswers.add(x + " + " + y + " = " + sum);
        }
        else{
            System.out.println("Wrong!");
            System.out.println("The correct answer is " +sum);     
        }
    }
    System.out.println("Correct answers:");
    for (String correctAnswer : correctAnswers) {
        System.out.println(correctAnswer);
    }