class FooDedicatedLogger {
    public void logOnSomething(Foo foo) {
        String message = "foo did something." + foo.getA() + foo.getB().getC();
        logger.log(logFile, message);
    }
}