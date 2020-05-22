public class StudentStore
{
    ArrayList<Student> students = null;

    public StudentStore()
    {
        students = new ArrayList<Student>();
    }

    public int size()
    {
        return (students == null) ? 0 : students.size();
    }
}