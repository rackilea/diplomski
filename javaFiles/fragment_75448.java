@Test
public void test() {
    String userName = null; // should add message
    ModelAndView modelAndView = Mockito.mock(ModelAndView.class);
    ResourceBundle resourceBundle = new ResourceBundle() {
        @Override
        protected Object handleGetObject(String key) {
            if ("invalidUserName".equals(key)) {
                return "mocked_string";
            }
            return null;
        }

        @Override
        public Enumeration<String> getKeys() {
            return Collections.emptyEnumeration();
        }
    };

    ParameterVerify parameterVerify = new ParameterVerify();
    parameterVerify.verifyParameters(userName, modelAndView, resourceBundle);
    Mockito.verify(modelAndView, Mockito.times(1)).addObject(Mockito.eq("invalidUserName"), Mockito.eq("mocked_string"));
}