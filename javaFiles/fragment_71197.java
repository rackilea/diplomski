@Test
 public void testRetrieve() {
    System.out.println("retrieve");
    String factories = "a,b,c";
    Transact instance = new Transact();
    List<Company> expResult = new ArrayList<>(); 
    Company com1=new Company("a","a");
    Company com2=new Company("b","b");
    Company com3=new Company("c","c");
    expResult.add(com1);
    expResult.add(com2);
    expResult.add(com3);
    List<Company> result = instance.retrieveData(factories);
    assertEquals(expResult, result);
 }