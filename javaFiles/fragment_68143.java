public class ObjectAB {
    Alpha a;
    Beta b;
    // Gettters and constructuor
}

    ObjectAB[] objArray = new ObjectAB[5]; 
// add obj1, obj2 to it.


    Map<Alpha, List<Beta>> map1 = new HashMap<>();
    for (ObjectAB objectAB : objArray) {
        Alpha a = objectAB.getA();
        List<Beta> bList = new ArrayList<>();
        if (map1.containsKey(a)) {
            bList = map1.get(a);
        }
        bList.add(objectAB.getB());
        map1.put(a, bList);
    }