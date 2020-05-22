Map map = new HashMap();
Set set = map.entrySet();
for (Map.Entry entry : set) {
} // Object cannot be cast to Entry
for (Map.Entry entry : map.entrySet()) {
} // Object cannot be cast to Entry