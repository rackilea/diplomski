Map<String, Double> map = new HashMap<String, Double>();

int i = 0;
while (i < foods.size() && i < value.length) { //for safety i will check on both sizes
    map.put(foods.get(i), value[i]);
    i++;
}