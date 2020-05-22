// This function will copy all values from one object and create a new object
// Stored copied values in it put in array list and return that arraylist 
public ArrayList<TestDTO> deepCopy(TestDTO testdto) {
   TestDTO testdtoCopy = new TestDTO();
   testdtoCopy.setAmount(testdto.getAmount());
   ArrayList<TestDTO> testDTOCopyArrayList = new ArrayList<TestDTO>();
   testDTOCopyArrayList.add(testdtoCopy);
   return testDTOCopy;
}