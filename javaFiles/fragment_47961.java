if(hashmap.contains(nameX)){
    entity obj = hashmap.get(nameX);
    type.add(new_val);
    amount.add(new_val);
    hashmap.put(nameX,obj);
}
else{
    entity obj = new entity();
    type.add(new_val);
    amount.add(new_val);
    hashmap.put(nameX,obj);
}