//given
XyzDao xyzDaoMock = mock(xyzDao);
//inject to XyzService class under test
given(xyzDaoMock.getData(id)).willReturn(Arrays.asList(...));

//when
xyzService.populateData()  //...XyzService uses mocked XyzDao

//then