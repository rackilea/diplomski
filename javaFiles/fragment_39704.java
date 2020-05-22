public class LevelMap {
    private static final ArrayList<String> EMPTY = Collections.emptyList();

    private ArrayList<String>[] levels;
    private int firstLevel;

    public LevelMap(int firstLevel, int lastLevel) {
        this.firstLevel = firstLevel;
        levels = new ArrayList<String>[lastLevel - firstLevel + 1];
    }

    public static void addToTypeMap(String key, String value, 
            int firstLevel, int lastLevel) {
        LevelMap l = types.get(key);
        if (l == null) {
            l = new LevelMap(firstLevel, lastLevel);
            types.put(key, l);
        } 
        l.add(value, firstLevel, lastLevel);
    }

    public void add(String value, int firstLevel, int lastLevel) {
        ensure(firstLevel, lastLevel);
        for (int i = firstLevel; i <= lastLevel; i++) {
            j = i - this.firstLevel;
            if (levels[j] == null) {
                levels[j] == new ArrayList<String>();
            }
            levels[j].add(value);
        }
    }

    private void ensure(int firstLevel, int lastLevel) {
        // Make sure that these levels are in the levelmap
        // If necessary, reallocate this.levels and adjust this.firstLevel
    }

    public String get(int level) {
        if (level < this.firstLevel ||
            level >= this.firstLevel + levels.length ||
            levels[level - this.firstLevel] == null) {
            return EMPTY;
        } else {
            return levels[level - this.firstLevel];
        }
    }
}