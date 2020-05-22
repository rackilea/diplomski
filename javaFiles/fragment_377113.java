try (Recording r = new Recording()) {
        r.enable("jdk.JavaExceptionThrow");
        r.start();
        new IOException();
        r.stop();
        dumpAndPrint(r, "Events for exception deriving from java.lang.Throwable");
    }

    try (Recording r = new Recording()) {
        r.enable("jdk.JavaErrorThrow");
        r.start();
        new InternalError();
        r.stop();
        dumpAndPrint(r, "Events for exception deriving from java.lang.Error");
    }
}

 void dumpAndPrint(Recording r, String title) throws IOException {
    System.out.println(title);
    Path p = Files.createTempFile("test", ".jfr");
    r.dump(p);
    for (RecordedEvent e : RecordingFile.readAllEvents(p))  {
        System.out.println(e);
    }
    System.out.println();
}