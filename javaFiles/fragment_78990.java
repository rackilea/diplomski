Mockito.doAnswer(new Answer() {
    Object answer(InvocationOnMock invocation) {
         ImagesSorter mock = (ImagesSorter) invocation.getMock();
         Object[] args = invocation.getArguments();

         return mock.sortImages((List<Image>) args[0], (UserInfo) args[1],
                 fakeNowDate);
    }
}).when(imagesSorterSpy).sortImages(imagesAsInsertionOrder, user);