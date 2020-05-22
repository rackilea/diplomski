Map<String, Integer> ipMap = map.get("ThomasGo");

//no map found for the username
if( ipMap == null ) { 
 //create a new inner map and put it into the outer map and keep the reference for further use
 ipMap = new TreeMap<>();
 map.put("ThomasGo", ipMap);
}

//check whether the ip is in the inner map
Integer ipCount = ipMap.get(ip);
if( ipCount == null) {
  //no count in the map so just put 1
  ipMap.put(ip, 1);
} 
else {
  //already a count in the map so overwrite it with count + 1
  ipMap.put(ip, ipCount  + 1);
}