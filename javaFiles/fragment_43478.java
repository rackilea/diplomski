@Test
void conditionalTest (
        @Mock final Service serviceMock, @Mock final Bar barMock) {

        final var id = "someId"

        // Create shared, stateful answer
        // First argument: Untill condition changes, return barMock
        // Second: After condition has changed, throw Exception
        final var conditional = ConditionalAnswer.create(
                () -> barMock,
                ConditionalAnswer.doThrow(new NoSuchElementException(someId)));

        // Whenever retrieveById is invoked, the call will be delegated to 
        // conditional answer
        when(service.retrieveById(any())).thenAnswer(conditional);


        // Now we can define, what makes the condition change.
        // In this example it is service#delete but it could be any other
        // method on any other class


        // Option 1: Easy but ugly
        when(service.deleteById(any())).thenAnswer(invocation -> {
           conditional.toggle();
           return Boolean.TRUE;
        });


        // Option 2: Answer proxy
        when(service.deleteById(any()))
                .thenAnswer(conditional.toggle(invocation -> Boolean.TRUE));


        // Now you can retrieve by id as many times as you like
        assertSame(barMock, serviceMock.retrieveById(someId));
        assertSame(barMock, serviceMock.retrieveById(someId));
        assertSame(barMock, serviceMock.retrieveById(someId));
        assertSame(barMock, serviceMock.retrieveById(someId));
        assertSame(barMock, serviceMock.retrieveById(someId));

        // Until
        assertTrue(serviceMock.deleteById(someId));

        // NoSuchElementException
        serviceMock.retrieveById(someId)

    }

}