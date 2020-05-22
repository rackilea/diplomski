@RunWith(PowerMockRunner.class)
@PrepareForTest(A.ProjectIdInitializer.class)
public class A {
    private MyService myService = new MyService();

    @Test
    public void testCreate() throws Exception {
        PowerMockito.mockStatic(ProjectIdInitializer.class);
        PowerMockito.doNothing().when(ProjectIdInitializer.class, "setProjectId", Mockito.any(String.class));

        System.out.println("Before");
        Response response = myService.create();
        System.out.println("After");
    }

    public static class ProjectIdInitializer {
        public static void setProjectId(String projectId) {
            //load spring context which i want  to escape in my test
            System.out.println(">>>>>> Game over");
        }
    }

    public static class Response {
    }

    public static class MyService {
        public Response create() {
            // ...
            ProjectIdInitializer.setProjectId("Test");
            return null;
        }
    }
}