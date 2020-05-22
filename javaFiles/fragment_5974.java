// Set up alternate System.err PrintStream that prints to a buffer
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream p = new PrintStream(bytes, true, "UTF-8");
    System.setErr(p);

    if (something == somethingElse) {
        System.err.println("This is a message");
    }

    // Here, I want to check if stderr is empty, or if something was printed
    // to it

    // Capture what was printed so far
    String printedSoFar = bytes.toString("UTF-8");