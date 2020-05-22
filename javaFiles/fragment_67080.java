public void myMethod() throws Exception {
    try {
        someMethod();
    }catch(NumberFormatException nfe) {
        nfe.printStackTrace();
    }
}