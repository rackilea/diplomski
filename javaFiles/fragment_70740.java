Pageable pageableStub = Mockito.mock(Pageable.class);
Page pageStub = Mockito.mock(Page.class);

Mockito.when(channelAccountRepository
    .findByCustomerAndChannelType(pageableStub, customer, ChannelType.FACEBOOK))
    .thenReturn(pageStub);

Page<ChannelAccount> channelAccountPage = channelAccountService
    .findByCustomerAndChannelType(pageableStub, customer, ChannelType.FACEBOOK);

assertTrue(pageResult == channelAccountPage);