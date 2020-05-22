public void testCaseOne(){
    // pseudocode for the mock - this will vary depending on your mock framework
    InputReader reader = createMock(InputReader);
    // the first time you read it will be a "1", the next time it will be an "x"
    expect(reader.read()).andReturn("1");
    expect(reader.read()).andReturn("x");

    PrintStream stream = createMock(PrintStream);
    // only expect the "1" to get written. the "x" is the exit signal
    expect(stream.println("1"));

    new YourClass(reader,stream).run();
    verifyMocks();
}