HashMap map = new HashMap();
for(int i = 0; i < list1.size(); i++) {
    Element e = list1.get(i);
    map.put(e.name, e.value);
}
for(int i = 0; i < list2.size(); i++) {
    Element e = list2.get(i);
    if(map.get(e.name) < e.value)
        map.put(e.name, e.value);
}