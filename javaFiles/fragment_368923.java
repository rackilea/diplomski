import static org.fest.assertions.Assertions.assertThat;

public class StudentTest {

    private final Student student = new StudentServiceImpl();

    @Test
    public void shouldReturnEmptyListOfStudentsWhenNotInitialized() {
        //given

        //when
        List<String> students = student.getStudentList();

        //then
        assertThat(students).isEmpty();
    }

    @Test
    public void shouldReturnSomeStudentsWhenListCreated() {
        //given
        student.createStudentList();

        //when
        List<String> students = student.getStudentList();

        //then
        assertThat(students).containsExactly("John", "Bill", "Ricky", "Jack");
    }

    @Test
    public void shouldStorePreviouslySetListOfStudents() {
        //given
        student.setStudentList(Arrays.asList("Jane", "Bob"));

        //when
        List<String> students = student.getStudentList();

        //then
        assertThat(students).containsExactly("Jane", "Bob");
    }

}