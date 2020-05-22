public class Test2
{
    static class LocationInfo
    {
        String lat;
        String lng;

        public LocationInfo(String lat, String lng)
        {
            this.lat = lat;
            this.lng = lng;
        }
    }

    private static final class PropKey {
        final Class<?> type;
        final String name;

        public PropKey(Class<?> type, String name) {
            this.type = Objects.requireNonNull(type);
            this.name = Objects.requireNonNull(name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, type);
        }
        @Override
        public boolean equals(Object obj) {
            if(obj==this) return true;
            if (obj == null || !(obj instanceof PropKey)) return false;
            final PropKey other = (PropKey) obj;
            return type==other.type && name.equals(other.name);
        }
    }
    private final Map<PropKey, Object> properties = new HashMap<>();

    public <T> T fetchProperty(Class<T> type, String name)
    {
        return type.cast(properties.get(new PropKey(type, name)));
    }
    // your decision whether this should be public
    <T> void putProperty(Class<T> type, String name, T value)
    {
        Objects.requireNonNull(value);
        properties.put(new PropKey(type, name), value);
    }

    public LocationInfo getPosition()
    {
        return fetchProperty(LocationInfo.class, "position");
    }

    public static void main(String[] args)
    {
        Test2 test = new Test2();
        test.putProperty(LocationInfo.class, "position", new LocationInfo("1", "1"));

        LocationInfo locationInfo = test.fetchProperty(LocationInfo.class, "position");
        System.out.println(locationInfo.lat + ", " + locationInfo.lng);

        LocationInfo locationInfo2 = test.getPosition();
        System.out.println(locationInfo2.lat + ", " + locationInfo2.lng);

        test.putProperty(String.class, "debugInfo", "hello world");
        System.out.println(test.fetchProperty(String.class, "debugInfo"));
    }
}