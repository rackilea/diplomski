Iterator<String> it = map.keySet().iterator();
while (it.hasNext())
    if (it.next().equalsIgnoreCase(currentKey))
        break;
while (it.hasNext()) {
    it.next();
    it.remove();
}