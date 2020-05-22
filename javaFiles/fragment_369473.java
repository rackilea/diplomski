public static String addSetValue(Map<String, Object> fieldMap) {
    StringBuilder  setQueryPart = new StringBuilder();
    for (Map.Entry<String, ? extends Object> entry: fieldMap.entrySet()) {
        if (entry.getValue() != null){
            setQueryPart.append(entry.getKey() + " = " +entry.getValue() + ", ");
        }
    }
    //Remove last comma, since we don't need it.
    setQueryPart.deleteCharAt(setQueryPart.lastIndexOf(","));
    return setQueryPart.toString();
}