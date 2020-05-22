Iterator it = headers.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pairs = (Map.Entry) it.next();
        result += pairs.getKey() + ": " + pairs.getValue() + "\n";
        it.remove();
    }