@Test
public void forGivenTypeOfInformationAndIcaoReturnUrl() {
    // here you created the mock
    PageControllerForNearestCity pcSpy = Mockito.spy(pc);
    // I'll assume that xmlParser is the subject of your test
    // and that you're injecting the mock like code below 
    xmlParser.setPageController(pcSpy);

    // Configure the mock and then you do the assertion
    assertThat(...)
}