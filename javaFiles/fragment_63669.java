public class MyTestClass extends WithApplication {
    @Test
    public void testSomething() {
        Helpers.running(Helpers.fakeApplication(), () -> {
            // *whatever mocking*
            RequestBuilder mockActionRequest = Helpers.fakeRequest(
                                         controllers.routes.MyController.processSomething());
            Result result = Helpers.route(mockActionRequest);
            // *whatever assertions* 
       });
     }
}