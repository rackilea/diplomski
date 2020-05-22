public class BetterImmutableExample {
    private List<String> myStrings; // This can not be referenced by the client

    public ImmutableExample(List<String> clientStrings) {
        myStrings = new ArrayList<String>(clientStrings);
    }
}