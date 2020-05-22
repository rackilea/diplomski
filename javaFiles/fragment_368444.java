Map<String, Double> mappings = //get mappings
List<ArrayList<String>> source = //get source
List<ArrayList<Double>> target = new ArrayList<>();
for(ArrayList<String> sourceElement : source){
    ArrayList<Double> targetElememt = new ArrayList<>();
    for(String sourceElementString : sourceElement){
        targetElememt.add(mappings.get(sourceElementString));
    }
    target.add(targetElememt);
}
System.out.println(target);