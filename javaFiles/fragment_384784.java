Map<String, Integer> itemsBought = new HashMap<String, Integer>();
    final String COUNTER = "counter";
    final String TENDER = "tender";
    String[] splitted = s.split(",");
    for (String str : splitted) {
        str = str.trim();
        if (str.startsWith(COUNTER)) {
            //do what you want with counter
        } else if (str.startsWith(TENDER)) {
            //do what you want with tender
        } else {
            //process items, e.g:
            String[] itemInfo = str.split(" ");
            itemsBought.put(itemInfo[0], Integer.valueOf(itemInfo[1]));
        }
    }