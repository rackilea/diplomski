Object[][] contents = getContents();
    HashMap<String,Object> temp = new HashMap<>(contents.length);
    for (int i = 0; i < contents.length; ++i) {
        // key must be non-null String, value must be non-null
        String key = (String) contents[i][0];
        Object value = contents[i][1];
        if (key == null || value == null) {
            throw new NullPointerException(); // <-- HERE
        }
        temp.put(key, value);
    }