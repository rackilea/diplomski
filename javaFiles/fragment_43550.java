Map<String, List<String>> stateCityMap= new HashMap<>();
String state;
String city;
while ((line=br.readLine())!=null){
    state=line.split("-")[0];
    city=line.split("-")[1];
    if(stateCityMap.get(state) == null) {
        stateCityMap.put(state, new ArrayList<String>());
    }
    stateCityMap.get(state).add(city);
}