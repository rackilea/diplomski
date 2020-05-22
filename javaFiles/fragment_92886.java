public static void method()
{
    double totalEarnedPoints = 1;
    double totalPossiblePoints = 1;
    double gradeScale[] = {1, 2, 3};
    double gradeCutoffs[] = {1, 2, 3};
    double gradePer = 0.0;
    char letter;
    double calcPercent = 1;

    gradePer = (totalEarnedPoints / totalPossiblePoints);
    char[] letterGrade = { 'A', 'B', 'C', 'D','F'};
    if (gradePer >= gradeScale[0])
    {
        letter = letterGrade[0];
    }
    else if (calcPercent >= gradeCutoffs[1] && calcPercent < gradeCutoffs[0])
    {
        letter = letterGrade[1];
    }
    else
        letter = 'F';

    System.out.println("Grade:"+letter);
}