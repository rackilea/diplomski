static ArrayList<Student> studentsList = new ArrayList<Student>();


public static ArrayList<Student> honorsStudents(Student[] list, int n)
{

    if (n==0)
    {
        return studentsList;
    }       
    else
    {
        boolean currentIsHonors = list[n-1].isHonors();
        if(currentIsHonors)
        {
            studentsList.add(list[n-1]);
            return honorsStudents(list, n-1);
        }
        else 
        {
            return honorsStudents(list, n-1);
        }
    }
}