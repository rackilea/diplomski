TreeMap<Integer, TreeMap<Integer, Integer>> values;
for (int x : values.subMap(x_min, x_max).keySet()) {
        for (int y : values.get(x).subMap(y_min, y_max).values()) {
            // y here, represents the value of points in range...
        }
    }