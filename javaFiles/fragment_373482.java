class IsListOfTwoElements extends ArgumentMatcher<List> {
     public boolean matches(Object list) {
         return ((List) list).size() == 2;
     }
 }

 List mock = mock(List.class);
 when(mock.addAll(argThat(new IsListOfTwoElements()))).thenReturn(true);
 mock.addAll(Arrays.asList("one", "two"));
 verify(mock).addAll(argThat(new IsListOfTwoElements()));