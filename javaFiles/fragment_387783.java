while (iterator.hasNext()) {
    String key = (String) iterator.next();
    String val = oldhashmap.remove(key);
    newhashmap.put(key, val);
}
newhashmap.putAll(oldhashmap);