@Test
public void testUpdate(){
     MyClass myClass = new MyClass();
     myClass.out = Mockito.spy(new PrintStream(...));

     // mock a call with an expected input
     doNothing().when(myClass.out).println("expected command");

     myClass.updateGreen();

     // test that there was a call
     Mockito.verify(myClass.out, Mockito.times(1)).println("expected command");
}