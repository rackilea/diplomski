public void yourOtherMethod() {
    try {
        yourMethod();
    } catch (YourException ex) {
        // handle exception
    }
}    

public void yourMethod() throws YourException {
    try {
        db.store(mydata);
    } finally {
        db.cleanup();
    }
}