/** Get a spied version of the given Consumer. */
private Consumer<Item> itemHandlerSpy(Consumer<Item> itemHandler) {
  // Create a spy of the Consumer functional interface itself.
  @SuppressWarnings("unchecked")
  Consumer<Item> spy = (Consumer<Item>) Mockito.spy(Consumer.class);
  // Tell the spy to run the given consumer when the Consumer is given something to consume. 
  Mockito.doAnswer(it -> {
    // Get the first (and only) argument passed to the Consumer.
    Item item = (Item) it.getArguments()[0];
    // Pass it to the real consumer so it gets processed.
    itemHandler.accept(item);
    return null;
  }).when(spy).accept(Mockito.any(Item.class));
  return spy;
}