List<List<Integer>> permutationS = new ArrayList<>();

// list initialization here

int i = 5; // the Integer you are searching for

for(List<Integer> innerList : permutationS) {
   if(innerList.contains(i)) {
     // found, do something with innerList
   }
}