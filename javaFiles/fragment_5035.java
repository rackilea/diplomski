while (it.hasNext()) {
        Map.Entry<String, Object> next = iterator.next();
        String key = next.getKey();
        Object value = next.getValue();
        if (!mystore.containsKey(key)) mystore.put(key, new LinkedList<String>());
        mystore.get(key).add(value.toString());
    }