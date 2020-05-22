for (Map<String, String> dic : dics) {
    Iterator<Map.Entry<String, String>> it = dic.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String, String> pair = it.next();
        String key = pair.getKey();
        String value = pair.getValue();
    }               
}