class RxProvider{
     fun provideIOScheduler()
     fun provideAndroidMainScheduler()
}

//Then you can call the rxprovider inside your presenter:
loginModel.loginUser(loginRequest)
    .subscribeOn(rxProvider.provideIOScheduler())
    .observeOn(rxProvider.provideAndroidMainScheduler())
// inside your test cases
when(rxProvider....).thenReturn(testSchedulers)