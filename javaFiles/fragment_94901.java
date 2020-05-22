public ArrayList<TestDTO> getTestDTO() {
   ArrayList<TestDTO> testDTOArrayList = new ArrayList<TestDTO>();
   TestDTO testdto = new TestDTO();
   testdto.setAmount("05");
   testDTOArrayList.add(testdto);
   this.setUserTest(testDTOArrayList);
   this.setCurrentTest(deepCopy(testdto));
   return testDTOArrayList;
}