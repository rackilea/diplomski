// as you want a sorted list of keys, you should use a TreeMap
    Map<String, Integer> stringsWithCount = new TreeMap<>();
    for (Message msg : convinfo.messages) {
        // where ever your input comes from: turn it into lower case,
        // so that "ccc" and "CCC" go for the same counter
        String item = msg.userName.toLowerCase();
        if (stringsWithCount.containsKey(item)) {
            stringsWithCount.put(item, stringsWithCount.get(item) + 1);
        } else {
            stringsWithCount.put(item, 1);
        }
    }
    String result = stringsWithCount
            .entrySet()
            .stream()
            .map(entry -> entry.getKey() + '(' + entry.getValue() + ')')
            .collect(Collectors.joining("+"));
    System.out.println(result);