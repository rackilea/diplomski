List<String> keys = new ArrayList<String>(map.keySet());
Random rand = new Random();
for (int i = 0; i < numColors; i++) {
    String key = keys.get(rand.nextInt(keys.size()));
    System.out.println(map.get(key));
}