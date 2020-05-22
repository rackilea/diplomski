@Test public void testExecuteTiti(){
  Toto toto = Mockito.spy(new Toto());
  Mockito.doReturn(2).when(toto).executeToto(Mockito.any(Tutu.class));

  Titi testedObject = new Titi(toto);
  testedObject.executeTiti();
}