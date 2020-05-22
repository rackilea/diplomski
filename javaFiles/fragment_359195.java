doAnswer(ans -> {
    Consumer<InputStream> callback = (Consumer<InputStream>) ans.getArguments()[1];
    InputStream stream = new ByteArrayInputStream(
            "test".getBytes(StandardCharsets.UTF_8.name()));
    callback.accept(stream);
    return null;
}).when(repository).actionOnFile(eq("any"), any(Consumer.class));