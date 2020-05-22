enum MyKeywords implements ProtocolKeyword {
    NEARBY, FENCE, POINT;

    private final byte name[];

    MyKeywords() {
        // cache the bytes for the command name. Reduces memory and cpu pressure when using commands.
        name = name().getBytes();
    }

    @Override
    public byte[] getBytes() {
        return name;
    }
}

CommandArgs<String, String> args = new CommandArgs<>(codec).addKey(key).add(MyKeywords.FENCE).add("POINT").add(lon).add(lat)
List<Object> response = connection.sync().dispatch(MyCommands.FENCE, new NestedMultiOutput<>(codec), args);