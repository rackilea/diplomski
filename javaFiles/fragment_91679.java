String[] keys = text.split("[!.?:;\\s]");
HashMap<String,Integer> uniqueKeys = new HashMap<>();

for(String key : keys){
    if(uniqueKeys.containsKey(key)){
        // if your keys is already in map, increment count of it
        uniqueKeys.put(key, uniqueKeys.get(map) + 1);
    }else{
        // if it isn't in it, add it
        uniqueKeys.put(key, 1);
    }
}

// You now have the count of all unique keys in a given text
// To print them to console

for(Entry<String, Integer> keyCount : uniqueKeys.getEntrySet()){
    System.out.println(keyCount.getKey() + ": " + keyCount.getValue());
}

// To merge, if you're using Java 8

for(Entry<String, Integer> keyEntry : uniqueKeys1.getEntrySet()){
    uniqueKeys2.merge(keyEntry.getKey(), keyEntry.getValue(), Integer::add);
}

// To merge, otherwise

for(Entry<String, Integer> keyEntry : uniqueKeys1.getEntrySet()){
    if(uniqueKeys2.containsKey()){
        uniqueKeys2.put(keyEntry.getKey(),
            uniqueKeys2.get(keyEntry.getKey()) + keyEntry.getValue());
    }else{
        uniqueKeys2.put(keyEntry.getKey(), keyEntry.getValue());
    }
}