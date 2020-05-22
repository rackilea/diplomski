String json= "[{'lng':116.298871, 'lat':39.991466},{'lng':116.298871, 'lat':39.990079}
    ,{'lng':116.295787, 'lat':39.990079},{'lng':116.295787, 'lat':39.991466}]]";
Gson gson = new Gson();
java.lang.reflect.Type collectionType= new TypeToken<List<Coordinate>>() {}.getType();
List<Coordinate> userList = gson.fromJson(json, collectionType);
System.out.println(userList);