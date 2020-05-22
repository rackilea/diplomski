@RunWith(EasyMockRunner.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepositoryMock;

    @TestSubject
    private ProjectService service;