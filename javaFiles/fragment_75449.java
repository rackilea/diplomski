@Test
public void test() {
    String userName = null; // should add message
    ModelAndView modelAndView = Mockito.mock(ModelAndView.class);
    ResourceBundle resourceBundle = null;

    ParameterVerify parameterVerify = new ParameterVerify();
    parameterVerify.verifyParameters(userName, modelAndView, resourceBundle);
    Mockito.verify(modelAndView, Mockito.times(1)).addObject(Mockito.eq("invalidUserName"), Mockito.eq("UserName cannot be null or empty or blank string"));
}