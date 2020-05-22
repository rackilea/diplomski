public class RecordingWriter implements Writer {
    private List<String> recordings = new ArrayList<>();

    @Override
    public void write(String output) {
        recordings.add(output);
    }

    public boolean contains(String incoming) {
        return recordings.contains(incoming);
    }
}

RecordingWriter writer = new RecordingWriter();
IOConsoleWriter io = new IOConsoleWriterImpl(writer);

io.displayAllClientsInfo(clients);

assertAll(
            () -> assertTrue(writer.contains(Long.toString(1))),
            () -> assertTrue(writer.contains("client@example.com")),
            () -> assertTrue(writer.contains("John Smith")),
            () -> assertTrue(writer.contains(Long.toString(2))),
            () -> assertTrue(writer.contains(LocalDateTime.of(2017,5,25,12,59).toString())),
            () -> assertTrue(writer.contains("JSmith")),
            () -> assertTrue(writer.contains("zzwvp0d9"))
    );