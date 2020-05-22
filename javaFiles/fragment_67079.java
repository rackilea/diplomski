public void myMethod() {
    try {
        someMethod();
    }catch(NumberFormatException nfe) {
        nfe.printStackTrace();
    }catch(Exception ex) {
        ex.printStackTrace();
    }
}