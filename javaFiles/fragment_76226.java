System.setSecurityManager(new SecurityManager() {
    @Override
    public void checkExit(int status) {
        throw new SecurityException("Not allowed.");
    }
});

try {
    System.exit(0);
} catch(SecurityException e) {
    System.out.println("Exit failed.");
} finally {
    System.out.println("I am finally block");
}
System.out.println("Program still running");