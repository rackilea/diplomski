List<Integer> values = // the list of values you have
Map<Integer,Integer> counts = new HashMap<Integer,Integer>();

for(Integer value : values) {
    if(counts.containsKey(value)) {
        counts.put(value, counts.get(value)+1);
    } else {
        counts.put(value, 1);
    }
}

List<Integer> resultValues = new ArrayList<Integer>();
for(Integer value : counts.keySet()) {
    Integer valueCount = counts.get(value);
    for(int i=0; i<(valueCount/2); i++) { //add one instance for each 2
        resultValues.add(value);
    }
}
return resultValues;