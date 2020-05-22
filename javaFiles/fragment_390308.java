public static void main(String[] args)
{
    Scanner keyboard = new Scanner(System.in);

    System.out.printf("Weight of Exam 1: ");
    double weightExamOne = keyboard.nextDouble();

    System.out.printf("Weight of Exam 2: ");
    double weightExamTwo = keyboard.nextDouble();

    System.out.printf("Do you know your score of first exam? ");
    String examOne = keyboard.nextLine();

    double examOneScore = 1;
    if(examOne.equalsIgnoreCase("yes") || examOne.equalsIgnoreCase("y"))
    {
        System.out.printf("Your score? ");
        examOneScore = keyboard.nextDouble();
    }

    System.out.printf("Do you know your score of second exam? ");
    String examTwo = keyboard.nextLine();

    double examTwoScore = 1;
    if(examTwo.equalsIgnoreCase("yes") || examTwo.equalsIgnoreCase("y"))
    {
        System.out.printf("Your score? ");
        examTwoScore = keyboard.nextDouble();
    }

    double csEx1 = (weightExamOne * examOneScore);
    double csEx2 = (weightExamTwo * examTwoScore );
}