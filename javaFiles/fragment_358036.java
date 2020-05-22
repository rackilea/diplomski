// myArray with 1,2,3,...,n values
int[] myArray = new int[] {1, 2, 3};

// Convert it in a List to use it through guava Collections
List<Integer> vals = Ints.asList(myArray);  

// Compute all permutations using Guava Collections API
Collection<List<Integer>> orderPerm = Collections2.orderedPermutations(vals);

// Convert the result in List of Lists to get indexed values by number (to display them, easier to access than using an Iterator)
List<List<Integer>> myTwoDimensionalArray = new ArrayList<>(orderPerm);

// Loop over the result to display the 2 dimensional array
for (int dim1 = 0 ; dim1 < myTwoDimensionalArray.size() ; dim1++) {

  String dim2 = "";
  // Here I build a string to display the numbers without the brackets (not necessary)
  for (int i = 0 ; i < myTwoDimensionalArray.get(dim1).size() ; i++) {
    if (i > 0) {
      dim2 += ",";
    }
    dim2 += myTwoDimensionalArray.get(dim1).get(i);
  }

  // Displaying the 2 dimensional results
  System.out.println(dim1 + " : " + dim2);
  // Uncomment here to display with brackets directly
  // System.out.println(dim1 + " : " + myTwoDimensionalArray.get(dim1));
}