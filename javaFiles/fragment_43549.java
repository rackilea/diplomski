MultiMap stateCityMap= new MultiHashMap();
String state;
String city;
while ((line=br.readLine())!=null){
    state=line.split("-")[0];
    city=line.split("-")[1];
    stateCityMap.put(state, city);
}