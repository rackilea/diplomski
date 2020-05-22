private static final Map<Integer, String> COLUMN_MAP = new HashMap();

private GridLayoutUtils() {
}

public static String getColumnClass(int columns) {
    return (String)COLUMN_MAP.get(Integer.valueOf(columns));
}

static {
    COLUMN_MAP.put(Integer.valueOf(1), "ui-grid-col-12");
    COLUMN_MAP.put(Integer.valueOf(2), "ui-grid-col-6");
    COLUMN_MAP.put(Integer.valueOf(3), "ui-grid-col-4");
    COLUMN_MAP.put(Integer.valueOf(4), "ui-grid-col-3");
    COLUMN_MAP.put(Integer.valueOf(6), "ui-grid-col-2");
    COLUMN_MAP.put(Integer.valueOf(12), "ui-grid-col-1");
}