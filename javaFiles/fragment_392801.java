Map<String, Integer> m = new HashMap<>();
m.put("A", 1);
m.put("B", 2);
m.put("C", 4);
// First, compute average
double average = m.values().stream().mapToDouble(Integer::doubleValue).average().orElse(0);
// Then, find entry closest to average
Map.Entry<String, Integer> e = m.entrySet().stream()
        .min(Comparator.comparing(a -> Math.abs(a.getValue() - average)))
        .orElse(null);