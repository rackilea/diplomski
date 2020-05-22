when(daoService.selectObject(anyString())).thenReturn(myObject);
Response registerFirstResponse = service.registerDevice(serialNumber, token, registrationDeviceRequest);

   createMyObjectJpa(field1,field2,field3);
   when(daoService.selectObject(anyString())).thenReturn(myObject); // here `myObject` was changed and now I say to Mockito, I want my new `myObject`

   Response registerSecondResponse = service.registerDevice(serialNumber, token, registrationDeviceRequest);