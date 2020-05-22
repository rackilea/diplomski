public String[] getAllKeys(){ 
    int i = 0;
    String allkeys[] = new String[buckets.length];
    KeyValue val = buckets[i];

    //Look at the first one          
    if(val != null) {             
        allkeys[i] = val.key; 
        i++;
    }

    //Iterate until there is no next
    while(val.next != null){
        allkeys[i] = val.next.key;
        val = val.next;
        i++;
    }

    return allkeys;
}