public static void smartCombine(ArrayList<Integer> first, ArrayList<Integer> second) {
     for(Integer num : second) {      // iterate through the second list
         if(!first.contains(num)) {   // if first list doesn't contain current element
             first.add(num);          // add it to the first list
         }
     }
}