public static void replaceWithTrueClone(List<String> list, int objIndex) {
    list.add(objIndex, new String(list.get(objIndex)));
    list.remove(objIndex + 1);
}

//OR

public static void replaceWithNewObject (List<String> list, int objIndex, String newObject) {
    list.add(objIndex, newObject);
    list.remove(objIndex + 1);
}