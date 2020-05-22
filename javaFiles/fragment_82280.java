public class Student extends TestStudent
{
    public String m_name;
    public int[] m_grades;

    public Student(String cName, int q1, int q2, int q3, int q4, int q5)
    {
        m_grades = new int[5];
        m_grades[0] = q1;
        m_grades[1] = q2;
        m_grades[2] = q3;
        m_grades[3] = q4;
        m_grades[4] = q5;
    }

public void setQuiz(int grade, int quiz, int student)
    {
        if (quiz > 0 && quiz <= num_quizzes && grade >= 0 && grade < MAX_GRADE) //Always check yout inputs!!
        {
            super.studentAr[student].m_grades[quiz-1] = grade; 
        }
    }
}