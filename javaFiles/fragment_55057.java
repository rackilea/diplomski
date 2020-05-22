@Test
public void testNoArgConstructor(){
    Log log = new Log();
    assertEquals(0, log.getNumCompleted());
    assertEquals(0, log.getTotalWaitTime());
    assertEquals(0, log.getTotalProcessTime());
}

@Test
public void testArgConstructor(){
    Log log = new Log(1,2,3);
    assertEquals(1, log.getNumCompleted());
    assertEquals(2, log.getTotalWaitTime());
    assertEquals(3, log.getTotalProcessTime());
}