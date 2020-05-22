IdEncryptor mockEncryptor = mock(IdEncryptor.class);
when(mockEncryptor.encryptIds(any(String.class)).thenReturn(new String[] {"a", "b"});

ToTest toTest = new ToTest(mockEncryptor);
String response = toTest.produceResponse("input");
// expect that the response is what you expect given "a", "b" as input of doStuff()