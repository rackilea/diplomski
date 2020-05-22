presenter.loadResource();

verify(mockNewsService).loadResource();

presenter.onResult(mockedNewsEntities);

// assert/verify if presenter is now in correct state