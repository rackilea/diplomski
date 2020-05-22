Drive mockDrive = mock(Drive.class, RETURNS_DEEP_STUBS);

....
// stubbing
when(service.files().get(anyString()).execute()).thenReturn(something);

// verify
verify(service.files().get("Some Field ID").execute();