String key = createKey(word);
List<String> scrambled = dWordMap.get(key);

//make sure that scrambled words list is initialized in the map for the sorted key.
if(scrambled == null){
    scrambled = new ArrayList<String>();
    dWordMap.put(key, scrambled);
}

//add the word to the list
scrambled.add(word);