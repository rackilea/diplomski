public class ColumnCharacterCount {
    private static final HashMap<Integer, HashMap<Character, Integer>> map =
            new HashMap<Integer, HashMap<Character, Integer>>();
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("ABSKSNFASLKFSAF");
        strings.add("LKGEROGNDFKGDFD");
        strings.add("GKDFLGSDFLGDFSJ");
        for (String str : strings) {
            for (int col = 0; col < str.length(); col++) {
                Character c = str.charAt(col);
                HashMap<Character, Integer> colMap = map.get(col);
                if (colMap == null) {
                    colMap = new HashMap<Character, Integer>();
                    map.put(col, colMap);
                }
                Integer charCounter = colMap.get(c);
                if (charCounter == null) {
                    charCounter = 0;
                }
                charCounter++;
                colMap.put(c, charCounter);
            }
        }
        Set<Entry<Integer, HashMap<Character, Integer>>> entrySet =
                map.entrySet();
        for (Entry<Integer, HashMap<Character, Integer>> entry : entrySet) {
            Integer key = entry.getKey();
            HashMap<Character, Integer> value = entry.getValue();
            System.out.printf("Column %2d has %s %n", key, value);
        }
    }
}