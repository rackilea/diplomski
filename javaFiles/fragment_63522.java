for (Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator(); iter.hasNext(); ) {
    Entry<Integer, Integer> entry = iter.next();
    Map.compute(entry.getKey(), (k, v) -> f(v));
    //do something for prevValue
}
....
private Integer prevValue;

private Integer f(Integer v){
    prevValue = v;
    return null;
}