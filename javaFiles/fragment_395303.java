Map map1;
Map map2;
List list2;
// iterate through all of the possible keys in order
for(Object possibleKey: List1) {
    // If the possible ke is a key in one of the maps,
    // add it to your new list.  This will preserve order.
    if(map1.containsKey(possibleKey))
        list2.add(map1.get(possibleKey));
    else if (map2.containsKey(possibleKey))
        list2.add(map2.get(possibleKey));
}