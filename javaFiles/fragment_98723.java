Writer writer = Mockito.mock(Writer.class);
IOConsoleWriter io = new IOConsoleWriterImpl(writer);

io.displayAllClientsInfo(clients);

Mockito.verify(writer).write(...);