public void findNode(HashMap map) {
    for(HashMap.Entry<String, Object> entry : map.entrySet()){
        Object value = entry.getValue();
        if(value instanceof String)
            System.out.println("value = "+value);
        else if(value instanceof HashMap)
            findNode(value);
        else if(value instanceof HashMap[])
            for(int i=0; i<array.length(); i++){
                findNode(array[i]);
    }
}