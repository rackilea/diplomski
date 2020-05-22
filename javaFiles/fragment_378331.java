//  select from the weighted elements
Random rand = new Random();
HashMap<Integer, Double> freqs = new HashMap<Integer, Double>();
int iterations = 10000;
for(int i = 0; i < iterations; i++) {
    double rnd = rand.nextDouble() * totalWeight;
    int elem = map.ceilingEntry(rnd).getValue();
    freqs.put(elem, (freqs.containsKey(elem) ? freqs.get(elem) : 0) + (1d/iterations));
}
Map<Integer, Double> sortedFreqs = new TreeMap<Integer, Double>(freqs);

for(Map.Entry<Integer,Double> entry : sortedFreqs.entrySet()) {
    System.out.printf("%02d: %.2f%% %n", entry.getKey(), entry.getValue() * 100d);
}