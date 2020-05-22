String input = "[key1]value1[key2]value2[key3]value3";

    // Gives ["", "key1", "value1", "key2", "value2", ...]
    String[] data = input.split("\\[|\\]");

    Map<String, String> dict = new HashMap<>();

    for(int i=1; i<data.length; )
        dict.put(data[i++], i == data.length ? "" : data[i++]);