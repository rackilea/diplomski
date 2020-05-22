private Map<Integer,Map<Integer,Integer>> transition = new HashMap<Integer, Map<Integer, Integer>>();
for (Integer outerKey : transition.keySet()) {
    Map<Integer, Integer> inner = transition.get(outerKey);
    for (Integer innerKey : inner.keySet()) {
        Integer value = inner.get(innerKey);
    }
}