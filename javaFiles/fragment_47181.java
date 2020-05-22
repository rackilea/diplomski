public void callback(TestLib.TestUnion testUnion)
  {
    testUnion.setType(TestLib.TestStruct.class);      
    testUnion.read();
    System.out.println(testUnion.testStruct.string == null ? "The string value is null" : "The string value is: " + testUnion.testStruct.string);
  }