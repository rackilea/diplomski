public class GradeCalculator
{

    public static void main(String[] args)
    {
        System.out.print("Please enter your grade:  ");
        Scanner input = new Scanner(System.in);
        String grade = input.nextLine().trim();

        GradeCalculator calculator = new GradeCalculator();

        double gradePoint = calculator.getGradePoint(grade);
        System.out.print("Your grade is: " + gradePoint);
    }

    private double getGradePoint(String grade)
    {
        int score = getGradeScore(grade.charAt(0));

        double modifier = 0;

        if (grade.length() > 1)
        {
            modifier = getModifierValue(grade.charAt(1));
        }

        return score + modifier;
    }

    private int getGradeScore(char grade)
    {
        int score = 0;

        switch (grade)
        {
            case 'A':
            case 'a':
                score = 4;
                break;
            case 'B':
            case 'b':
                score = 3;
                break;
            case 'C':
            case 'c':
                score = 2;
                break;
            case 'D':
            case 'd':
                score = 1;
                break;
            case 'F':
            case 'f':
                score = 0;
                break;
        }

        return score;
    }

    private double getModifierValue(char modifier)
    {
        double value = 0;

        switch (modifier)
        {
            case '+':
                value = 0.3;
                break;
            case '-':
                value = -0.3;
                break;
        }

        return value;
    }
}