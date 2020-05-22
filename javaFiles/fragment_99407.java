Capture<Class<?>> classCapture = new Capture<Class<?>>();
EasyMock.expect(object.foo(EasyMock.capture(classCapture)));

// ... other test setup ...

Assert.assertEquals(classCapture.getValue(), String.class);