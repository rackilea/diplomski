final CommunicationQueue queue = context.mock(CommunicationQueue.class);
final TransactionRollBack trans = context.mock(TransactionRollBack.class);

context.checking(new Expectations() {{
    oneOf(queue).retrieve(with(any(int.class)));
    will(returnValue(null));
    never(trans);
}});

RunResponse r = new RunResponse(queue, trans); // depending on the order
r.processResponseImpl(-1);