public class MyInstanceCreator {
    public static DestinationObject createDestinationObject() {
        DestinationObject result = new DestinationObject();
        result.setCountries(new LinkedHashSet<Country>());
        return result;
    }
    private MyInstanceCreator() { }
}