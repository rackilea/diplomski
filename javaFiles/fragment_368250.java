//HashMap in inner class
public static class InnerMap
{
    private static final Map<String, Day> ABBREV_MAP = new HashMap<String, Day>();
}
//Constructor
private Day(String abbreviation) {
    this.abbreviation = abbreviation;
    InnerMap.ABBREV_MAP.put(abbreviation, this);
}