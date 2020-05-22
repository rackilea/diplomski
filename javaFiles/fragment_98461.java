@Captor
 ArgumentCaptor<List<B>> captor;

 // then in test
 ...
 verify(a).foo(captor.capture());
 List<B> values = captor.getValue();
 assertThat(values, IsIterableContainingInOrder.containingInOrder(new BMatcher(expected));
 ...