public class OfficeDeliveryTracker {
    private SortedMap<String, List<String>> deliveryTracker;

    /**
     * Constructor for objects of class OfficeDeliveryTracker
     */
    public OfficeDeliveryTracker() {
        this.deliveryTracker = new TreeMap<>();
    }

    /**
     * Adds key-value pair to the map
     */
    public void addMapEntry(String key, String value) {
        List<String> list = deliveryTracker.get(key);
        if (list == null) {
            list = new ArrayList<String>();
        }
        list.add(value);
        deliveryTracker.put(key, list);
    }

    public static void main(String[] args) {
        OfficeDeliveryTracker tracker = new OfficeDeliveryTracker();
        //tracker.put("17/06/2019", "Jeffrey Burns"); // Error : The method put(String, String) is undefined for the type OfficeDeliveryTracker;
        tracker.addMapEntry("17/06/2019", "Jeffrey Burns");
    }
}