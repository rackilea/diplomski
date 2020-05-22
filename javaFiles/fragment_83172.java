if(clusterMap.containsKey(num )){
     clusterMap.get(num).add(lineNumber);
}
else{
    ArrayList<Integer> list = new ArrayList<>();
    list.add(lineNumber);
    clusterMap.put(num, list);
}