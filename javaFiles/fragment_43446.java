public void findNode(HashMap map) {
    for(HashMap.Entry<String, Object> entry : map.entrySet()){
        findNode(entry.getValue());
    }
}

public void findNode(String value) {
    System.out.println("value = "+value);
}

public void findNode(HashMap[] value) {
    for(int i=0; i<array.length(); i++){
        findNode(array[i]);
    }
}