public void putNumber(String name, Integer number) {
    Iterator<String> i = h.keySet().iterator();
    if (i.equals(name)) {
        h.put(name, number);
    } else {
        h.put(name, number);
        dataCount++;
    }
}