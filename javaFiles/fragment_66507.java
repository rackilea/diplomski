Iterator <Map<String, String>> iterator = list.iterator();
while (iterator.hasNext()){
    Map<String, String> map = iterator.next();

    for (String key: map.keySet()){
        System.out.println(key + " " + map.get(key).toString());
    }
}