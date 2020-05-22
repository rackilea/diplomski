Deque<Pair<SomeObject, Integer>> processResult = new ArrayDeque(processInBatch(couldBeProcessed)); 

for (int i = 0; i < input.size(); i++) {
    if (map.containsKey(i)) {
        result.add(map.get(i));
    } else {
        result.add(processResult.removeFirst());
    }
}