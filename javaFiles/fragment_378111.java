// Setup
Map<Integer, Integer> map = new HashMap<Integer, Integer>();

map.put(1, 1);
map.put(2, 2);
map.put(3, 3);
map.put(4, 4);
map.put(5, 5);

int Rwiner = 3, Rsec = 5;

map.remove(Rwiner);
map.remove(Rsec);

// Get random entry from current map.
Random rnd = new Random();
int randomIndex = rnd.nextInt(map.size());
int randomKey = new ArrayList<Integer>(map.keySet()).get(randomIndex);
System.out.printf("Random entry: %d -> %d", randomKey, map.get(randomKey));