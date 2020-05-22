File mocked = Mockito.mock(File.class);
// create file as you want
File realFile = new File(WORKING_PATH);
// tell PowerMockito to return it
PowerMockito.whenNew(File.class).withParameterTypes(String.class)
            .withArguments(Mockito.eq(WORKING_PATH)).thenReturn(realFile);
// tell PowerMockito to return mock if other argument passed
PowerMockito.whenNew(File.class).withParameterTypes(String.class)
            .withArguments(Mockito.eq(THE_TARGET_PATH)).thenReturn(mocked);

File normalFile = new File(WORKING_PATH);
File mockedFile = new File(THE_TARGET_PATH);