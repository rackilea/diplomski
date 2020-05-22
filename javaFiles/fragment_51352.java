@RunWith(MockitoJUnitRunner.class)
public class TestStudentContoller {

    @Mock
    StundentService mockStudentService;
    @InjectMocks
    StudentController studentController = new StudentController();

    @Test
    public void testInsertStudent(){

        Student student = new Student();

        studentContoller.insertStudent(student);

        verify(studentService, times(1)).insertStudent(student);
    }