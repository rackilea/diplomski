public static void main(String[] args) {
    int score = 0;
    int correct = 0;
    int done = 0;
    Scanner scan = new Scanner(System.in);
    boolean repeatValue = false;
    int num1 = 0; // put values outside while in order to re-use them when we need to repeat the same question
    int num2 = 0;
    while (true) {
        try {
            // if the user input was incorrect (repeatValue = true), use old the previous values for num1 and num2
            num1 = repeatValue ? num1 : (int) (Math.random() * 20);
            num2 = repeatValue ? num2 : (int) ((Math.random() * 20) + 1);
            System.out.printf("%d  %% %d = ?\n", num1, num2);
            repeatValue = false;  // restore flag state
            if (scan.hasNext("q"))
                break;
            if (scan.nextInt() == (num1 % num2)) {
                score += 20;
                done += 1;
                correct += 1;
                System.out.println(
                        "Correct answer,current score :" + score + ",performance: " + correct + "/" + done);
            } else {
                done += 1;
                System.out.println(
                        "Incorrect answer, Current score:" + score + ", performance: " + correct + "/" + done);
            }
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
            scan.next();
            repeatValue = true; // flag set to use the same values as before
        }
    }
    System.out.println("Finish");
}