Iterator<Map<String, Object>> iter = manyObjects.iterator();
while (iter.hasNext()) {
    Map<String, Object> anObject = iter.next();
    if (anObject.get("x").equals("y")) {
        iter.remove();
    }
}