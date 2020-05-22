List<Integer> listSnapshot;

@Test
public void testWithVerify() {
  List<Integer> originalList = new ArrayList<>();
  originalList.add(1);
  Mockito.when(mockDependency.add(any())).thenAnswer(invocation => {
    listSnapshot = new ArrayList<>((List<Integer>) (invocation.getArguments()[0]));
  });

  app.addToClonedList(originalList);

  assertEquals(originalList, listSnapshot);
}