@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);

    //configure the mock
    // Java 8 - style 2 - assuming static import of AdditionalAnswers
    doAnswer(answerVoid(ItemUpdate update) -> {
        Item item = new Item();
        //...populate item as needed

        update.update(item);
    })
    .when(someManagerMock).doSomething(any(ItemUpdate.class));

    this.someClass = new SomeClass(someManagerMock);
}