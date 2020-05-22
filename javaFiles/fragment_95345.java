public class Test {
   private static Map<String, Location> locations = new HashMap<String, Location>();
   // Or list or straight variables or other way of holding the locations
   // Some structure to hold the hotels will be necessary too


   public static void addLocations()
   {
      locations.put("Washington", new Location("Washington", "DC"));
      // Same line for other locations
   }


   public static void addHotels()
   {
      Hotel h = new Hotel(locations.get("Washington"), <other fields>);
      // Add the hotel to the list/map whatever of hotels to use it elsewhere
   }