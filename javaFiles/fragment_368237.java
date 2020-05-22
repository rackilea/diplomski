else if(score >= 63 && score <= 94)
{
    grade = 0.7;
    for (int i = 63, i <= score; i++)
    {
        grade += 0.1;
    }
    return grade;
}