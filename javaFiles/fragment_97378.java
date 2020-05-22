int[] array = {10,15,1,2,3,4,5,11,12};
List<Integer> tempList = new ArrayList<>(); // prepare temp list for later use
List<List<Integer>> arrays = new ArrayList<>(); // used to store the sequences
int lastNum = array[0]; // get the fist number for compasion in loop
tempList.add(lastNum);
for (int i = 1; i < array.length; i++) {
    if (array[i]-1 == lastNum) { // check for sequence (e.g fist num was 12,
      // current number is 13, so 13-1 = 12, 
      // so it has the sequence), then store the number
        tempList.add(array[i]); // store it to the temp list
        lastNum = array[i]; // keep current number for the next
    } else { // if it has not the sequence, start the new sequence
        arrays.add(tempList); // fist store the last sequence
        tempList = new ArrayList() // clear for the next sequence
        lastNum = array[i]; // init the lastNumnber
        tempList.add(lastNum);
    }
}
// now iterate for the longest array
// craete an empty array to store the longest
List<Integer> longestLength = new ArrayList<>();
for (List<Integer> arr : arrays) {
    if (arr.size() > longestLength.size()) {
        // check if the current array hase the longest size than the last one
        // if yes, update the last one
        longestLength = arr;
    }
}
// at the end print the result.
System.out.println("longestLength = " + longestLength);