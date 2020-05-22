void methodB() throws SomeException {
    try {
        //Something that can throw SomeException
    } catch (SomeException e) {
        //rethrow e
        throw e;
    }
}

void methodA() {
    try {
        methodB();
    } catch (SomeException e) {
        //this block will run if methodB throws SomeException
    }
}