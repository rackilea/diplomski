Iterator<Map.Entry<String,String>> iter = testMap.entrySet().iterator();
while (iter.hasNext()) {
    Map.Entry<String,String> entry = iter.next();
    if("Sample".equalsIgnoreCase(entry.getValue())){
        iter.remove();
    }
}