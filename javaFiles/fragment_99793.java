public class Original {
    private ComplicatedService service;

    public Original(ComplicatedService service) {
        this.service = service;
    }

    public void someMethod() {
        // ... stuff
        Object someValue = service.callComplicatedMethod();
        // ... more stuff
    }
}