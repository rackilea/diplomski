// 8 bytes per field.
public static MapLocation[] NORTH = locations("\u006a\u0079\u007a\u0089\u008a\u008b\u0099\u009a\u009b\u00aa");

// 57 bytes.
public static MapLocation[] locations(String s) {
    final int len = s.length();
    MapLocation[] locations = new MapLocation[len];
    for (int i = 0; i < len; i++) {
        char ch = s.charAt(i);
        locations[i] = new MapLocation((ch >> 4) - 8, (ch & 0xf) - 8);
    }
    return locations;
}

static class MapLocation {
    public MapLocation(int x, int y) {
        System.out.println("x=" + x + ", y=" + y);
    }
}