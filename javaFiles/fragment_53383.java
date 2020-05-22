class makeArrayList extends ArrayList<Integer> {
   ArrayList<Integer> myArrayList = new ArrayList<Integer>();

   public makeArrayList(double[] myArray, int arrayLength) {
      // NOTE: My actual code does many transformations to myArray. The
      // resulting myArrayList
      // contains only 1/1000 of the points in myArray. This code is just
      // simplified for debugging.
      for (int i = 0; i < arrayLength; i++) {
         myArrayList.add((int) Math.pow(myArray[i], 2));
      }
      System.out.println("in makeArrayList, PeakList.size() is: "
            + myArrayList.size());
   }
}