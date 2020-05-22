if(wordPartitions.containsKey(key)) {
    tempList = wordPartitions.get(key);
} else {
    wordPartitions.put(key, new ArrayList<String>());                
}

if (tempList!=currentList) {
    tempList.add(word);
}