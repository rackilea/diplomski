public class BadImmutableExample {
    private List<String> myStrings; // This can not be referenced by the client

    /*...*/

    public List<String> getMyStrings() {
        return myStrings;
    }
}