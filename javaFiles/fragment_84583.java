XYZServiceImpl realService = new XYZServiceImpl();
XYZServiceImpl spy = Mockito.spy(realService);

when(spy.fetchSet1Details()).thenReturn(whaeveryouneed);
when(spy.getXYZMapper()).thenReturn(mockMapper);

spy.methodUnderTest();