key = getPartitionKey(word, choice);

if(wordPartitions.containsKey(key)) {
    tempList = wordPartitions.get(key);
    tempList.add(word);
    wordPartitions.put(key, tempList);
} else {