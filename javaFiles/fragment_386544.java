public static void put(LinkedHashMap<String, String> input, 
                                 int index, String key, String value) {

    if (index >= 0 && index <= input.size()) {
        LinkedHashMap<String, String> output=new LinkedHashMap<String, String>();
        int i = 0;
        if (index == 0) {
            output.put(key, value);
            output.putAll(input);
        } else {
            for (Map.Entry<String, String> entry : input.entrySet()) {
                if (i == index) {
                    output.put(key, value);
                }
                output.put(entry.getKey(), entry.getValue());
                i++;
            }
        }
        if (index == input.size()) {
            output.put(key, value);
        }
        input.clear();
        input.putAll(output);
        output.clear();
        output = null;
    } else {
        throw new IndexOutOfBoundsException("index " + index
                + " must be equal or greater than zero and less than size of the map");
    }
}