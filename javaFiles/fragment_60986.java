@Test
public void test(){
  final SomeRepository repo = mock(SomeRepository.class);
  final SomeService serv = new SomeService(repo);

  final YourClass clazz = mock(YourClass.class);

  when(repo.save(clazz)).thenReturn(clazz);

  YourClass response = serv.save(clazz);

  Assert.assertEquals(clazz,response);

  verify(repo).save(clazz);
}