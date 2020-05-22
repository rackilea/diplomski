@Filter(inputChannel = "input", outputChannel = "transformerChannel")
public boolean accept(final Message<?> message) {
    final MyObject payload = (MyObject) message.getPayload();
    return payload.getName().equals("test");
}


@Transformer(inputChannel = "transformerChannel", outputChannel = "output")
public OtherObject transform(final MyObject data) {
    return convert(data);
}