void methodB() throws SomeException {
    //Something that can throw SomeException: don't catch it
}

void methodA() {
    try {
        methodB();
    } catch (SomeException e) {
        //this block will run if methodB throws SomeException
    }
}