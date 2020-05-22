Iterator<Entry<String, String>> it = map.entrySet().iterator();
if (it.hasNext()) {
    Entry<String, String> first = it.next();
}
if (eventHappened && it.hasNext()) {
    Entry<String, String> second = it.next();
}