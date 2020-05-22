public static void main(String[] args)
{
    EventsSearchResponse r = new EventsSearchResponse();
    r.mapEntries = new ArrayList<>();
    MapEntryType t = new MapEntryType();
    t.key = "key1";
    t.value = new Integer(1);
    r.mapEntries.add(t);
    t = new MapEntryType();
    t.key = "key2";
    t.value = new Integer(2);
    r.mapEntries.add(t);
    t = new MapEntryType();
    t.key = "key2";
    t.value = new String[0];
    r.mapEntries.add(t);

    try {
        System.out.println(new ObjectMapper().writeValueAsString(r));
    } catch (Exception e) {
        e.printStackTrace();
    }
}