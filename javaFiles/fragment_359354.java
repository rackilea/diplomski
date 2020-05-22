public void setSelectedKey(String key){
    selectedItem = values.ceilingEntry(key);
    setSelectedItem(key);
}

public void setSelectedItem(String key, String value){
    values.put(key, value);
    setSelectedKey(key);
}