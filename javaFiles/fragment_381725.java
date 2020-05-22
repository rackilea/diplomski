/* Unit tests for HelloWorldAction */
public class HelloWorldActionTest
{
    @Test
    public void testExecute() throws Exception
    {
        final String expectedGreeting = "Hello Test!";
        String expectedForward = "success";

        HelloWorldAction testAction = new HelloWorldAction() {
            /* Override dependency injection method to substitute a mock impl */
            @Override
            protected HelloWorldDAO newHelloWorldDAO()
            {
                return new HelloWorldDAO() {
                    @Override
                    public String findGreeting()
                    {
                        return expectedGreeting;
                    }
                };
            }
        };

        String actualForward = testAction.execute();
        String actualGreeting = testAction.getGreeting();

        assertEquals("forward", expectedForward, actualForward);
        assertEquals("greeting", expectedGreeting, actualGreeting);
    }
}