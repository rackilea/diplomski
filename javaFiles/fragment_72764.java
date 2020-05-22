Iterator<String> firstMapIterator = firstMap.keySet().iterator();
while (firstMapIterator.hasNext()) {
    if(!secondMap.containsKey(firstMapIterator.next())) {
        firstMapIterator.remove();
        break;
    }
}