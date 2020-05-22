LOGGER_mock = mock(LoggerClass.class);
// inject LOGGER_mock into class to test, eventually use reflection to change
//  a private attribute

classToTest.showOutputOfIdentifications(10);
verify(LOGGER_mock).info("25 or Under");