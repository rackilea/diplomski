Mockito.when(this.service.getItems(Mockito.any()))
       .thenAnswer(new Answer<Flux<Item>>() {

    @Override
    public Flux<Item> answer(InvocationOnMock invocation) throws Throwable {
        Mono<ItemParams> mono = (Mono<ItemParams>)invocation.getArgument(0);

        if(/* verify that paseed mono contains new ItemParams("1")*/){
          return result;
        }

        return null;
    }
});