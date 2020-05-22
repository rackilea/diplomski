ArrayList<String> newKeys = new ArrayList<>();  //java 7 syntax
ArrayList<String> oldKeys = new ArrayList<>();
//store keys from files.

TreeMap<Integer, Integer> commonKeys = new TreeMap<Integer, Integer>();
//stores the index values from newList as keys that get mapped to the old list index.

ArrayList<Integer> removedKeys =ArrayList<>();  
// Store the indices from oldKeys that are not in newKeys.

int newListIndex = 0;
int oldListIndex = 0;
while(newListIndex < newKeys.size() && oldListIndex<oldKeys.size()) {
   if(newKeys.get(newListIndex).equals(oldKeys.get(oldListIndex) ) {
      commonKeys.put(newListIndex,oldListIndex);
      oldListIndex++; newListIndex++ 
   }
   else if(newKeys.get(newListIndex).compareTo(oldKeys.get(oldListIndex)>0 ) {
      removedKeys.add(oldListIndex);
      oldListIndex++
   }
   else {
      //maybe this is a newListIndex that is not in the old list, so it was added.
      newListIndex++;
   }
}