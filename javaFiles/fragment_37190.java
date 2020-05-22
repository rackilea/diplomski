@Test
    public testChildDetailsMethod(){
       ChildDetailsSpy childSpy = spy(new ChildDetailsSpy());
       doNothing().when(childSpy).validate();
       childDetails.setAge(20);
       ...
   }