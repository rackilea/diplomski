Object object = Mockito.spy(new Object());
Mockito.when(object.toString()).thenThrow(new RuntimeException()).thenReturn("yeha");

try {
  System.out.println(object.toString());
  fail();
} catch(RuntimeException r) {
  System.out.println(object.toString());
}