@RunWith(MockitoJUnitRunner.class)
public class TestStudentContoller {

    @Mock
    StundentService mockStudentService;
    @InjectMocks
    StudentController studentController = new StudentController();

    MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standAloneSetup(studentController).build();
    }

    @Test
    public void testInsertStudent(){

        Student student = new Student();

        studentContoller.insertStudent(student);

        mockMvc.perform(post("path/to/insert/student")
            .accept(MediaType.APPLICATION_JSON)
            .andExpect(status().isOk())
            .andExpect(content().string("{}"));//put json student in here

        verify(studentService, times(1)).insertStudent(student);
    }