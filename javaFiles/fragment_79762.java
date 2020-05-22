//Example repository interface.
public interface StudentRepository
{
   public List<Student> getAllStudents();
}

//Example mock database class.
public class MockStudentRepository implements StudentRepository
{
   //This method creates fake but known data.
   public List<Student> getAllStudents()
   {
      List<Student> studentList =  new ArrayList<Student>();
      studentList.add(new Student(...));
      studentList.add(new Student(...));
      studentList.add(new Student(...));

      return studentList;
   }
}

//Example method to test.
public int computeAverageAge(StudentRepository aRepository)
{
   List<Student> students = aRepository.GetAllStudents();
   int totalAge = 0;
   for(Student student : students)
   {
      totalAge += student.getAge();
   }

   return totalAge/students.size();
}

//Example test method.
public void testComputeAverageAge()
{
   int expectedAverage = 25; //What the expected answer of your result set is
   int actualAverage = computeAverageAge(new MockStudentRepository());

   AssertEquals(expectedAverage, actualAverage);
}