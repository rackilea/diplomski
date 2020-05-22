private Map<String, Integer> userGains = new HashMap<String, Integer>();

private Object[][] testUsers = { { "Test user", 15 }, { "Test", 25 }, { "Hello", 11 }, { "I'm a user", 21 }, { "No you're not!", 14 }, { "Yes I am!", 45 }, { "Oh, okay.  Sorry about the confusion.", 0 }, { "It's quite alright.", 0 } };

public static void main(String[] arguments) {
    new Sorting().sortGains();
}

public void sortGains() {
    for (Object[] test : testUsers) {
        userGains.put((String) test[0], (Integer) test[1]);
    }

    Map<String, Integer> map = createSortedMap(userGains);

    for (Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + " gained " + entry.getValue() + "  experience.");
    }
}

public Map<String, Integer> createSortedMap(Map<String, Integer> passedMap) {
    List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(passedMap.entrySet());

    Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {

        @Override
        public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
            if (!e1.getValue().equals(e2.getValue())) {
                return e1.getValue().compareTo(e2.getValue()) * -1; // The * -1 reverses the order.
            } else {
                return e1.getKey().compareTo(e2.getKey());
            }
        }
    });

    Map<String, Integer> orderedMap = new LinkedHashMap<String, Integer>();

    for (Entry<String, Integer> entry : entryList) {
        orderedMap.put(entry.getKey(), entry.getValue());
    }

    return orderedMap;
}