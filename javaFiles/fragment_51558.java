int[] roll = { 3, 3, 4, 4, 5, 5, 5 };

Map<Integer, Integer> counts = new HashMap<>(roll.length);

for (int a : roll)
    counts.put(a, counts.containsKey(a) ? counts.get(a) + 1 : 1);

for (Entry<?, Integer> e : counts.entrySet())
    if (e.getValue() > 1)
        System.out.println(e.getKey() + "\t" + e.getValue());