public void runTest(Runnable code) {
    try {
        code.run();
    } catch(Exception e) {
        //doing rollback
    }
}