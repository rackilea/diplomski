private Map<Integer,Integer> finalValues = new HashMap<Integer,Integer>();

for (Pair<Integer,Integer> entry : preBusinessList) {
    finalValues.put(entry.getFirst(), entry.getSecond());
}
//2nd list overwrites values from 1st (anything not overwritten remains)
for (Pair<Integer,Integer> entry : businessList) {
    finalValues.put(entry.getFirst(), entry.getSecond());
}
ArrayList<Pair<Integer,Integer>> finalList = new ArrayList<>();
for (Map.Entry<Integer,Integer> entry : finalValues) {
   finalList.add(new Pair(entry.getKey(), entry.getValue());
}
//and now sort the list
Collections.sort(finalList, new Comparator<Pair<Integer,Integer>> {
    int compare(Pair<Integer,Integer> a, Pair<Integer,Integer>b) {
       return a.getFirst.compareTo(b.getFirst()); //compare by 1st number in pair only
    }
});