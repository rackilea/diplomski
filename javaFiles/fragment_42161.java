// NOTE! I assume that elements of theArray are Integers, not primitives like ints
// You'll nee to cast things to Integers if they are ints to put them in a Map as
// Maps can't take primitives as keys or values
Map<Integer, Integer> elementCount = new HashMap<Integer, Integer>();
for (int i = 0; i < theArray.length; i++) {
   if (elementCount.containsKey(theArray[i]) {
     elementCount.put(theArray[i], new Integer(elementCount.get(theArray[i]) + 1));
   } else {
     elementCount.put(theArray[i], new Integer(1));
   }
}

List<Integer> moreThanOne = new ArrayList<Integer>();
for (Integer key : elementCount.keySet()) { // method may be getKeySet(), can't remember
   if (elementCount.get(key) > 1) {
      moreThanOne.add(key);
   }
}

// do whatever you want with the moreThanOne list