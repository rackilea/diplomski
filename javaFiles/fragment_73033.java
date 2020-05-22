class CustomExpectedException extends ExternalResource /*implements (!) TestRule*/ {

    private ExpectedException expExc = ExpectedException.none();

    /* Parameterize the message and also the class, if it fits your needs, 
     * alternatively && additionally implement defaults/constants/more methods.*/
    public void myExpect(String substr) {
        expExc.expect(MyCustomException.class);
        expExc.expectMessage(substr);// other matchers possible
    }
}