public List<String> getPropertyValues(String prefix) {
    List<String> values = new ArrayList<>();
    for(int i=1;;i++) {
        String value = (String) PropertyManager.getValue(prefix + i, null);
        if(value == null){
            break;
        }
        values.add(value);          
    }
    return values;
}