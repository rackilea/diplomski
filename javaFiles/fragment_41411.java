//Oops, thenReturn() part is missing:
 when(mock.get());

 //Oops, verified method call is inside verify() where it should be on the outside:
 verify(mock.execute());

 //Oops, missing method to verify:
 verify(mock);