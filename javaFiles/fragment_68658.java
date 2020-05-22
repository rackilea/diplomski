for (Entry<String, List<Object>> entry : map.entrySet()) {
    out.print("Key = " + entry.getKey() + ", values = ");
    for (Iterator<Object> iter = entry.getValue().iterator(); iter.hasNext();) {
        Object item = iter.next();
        out.print(item + (iter.hasNext() ? ", " : ""));
    }
    out.println();
}