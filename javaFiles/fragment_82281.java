public void setQuiz(int grade, int quiz, int student) 
{
    if (quiz == 1)
        super.studentAr[student].q1 = grade;
    if (quiz == 2)
        super.studentAr[student].q2 = grade;
    if (quiz == 3)
        super.studentAr[student].q3 = grade;
    if (quiz == 4)
        super.studentAr[student].q4 = grade;
    if (quiz == 5)
        super.studentAr[student].q5 = grade;
}