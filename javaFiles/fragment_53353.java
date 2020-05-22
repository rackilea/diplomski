@RunWith(PowerMockRunner.class)
@PrepareForTest(ProjectIdInitializer.class)
public class MyServiceTest{
  private MyService myService = new MyService();

  public void testCreate()
  {
    PowerMockito.mockStatic(ProjectIdInitializer.class);
    PowerMockito.doNothing().when(ProjectIdInitializer.class, "setProjectId", Mockito.any(String.class));

    Response response=myService.create();
  }
}