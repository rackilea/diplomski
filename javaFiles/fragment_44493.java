public static OuterEnum instantiate(SerializationStreamReader streamReader) throws SerializationException {
            int ordinal = streamReader.readInt();
            OuterEnum[] values = OuterEnum.values();
            assert (ordinal >= 0 && ordinal < values.length);
            return values[ordinal];
}

    public static void serialize(SerializationStreamWriter streamWriter, OuterEnum instance) throws SerializationException {
            assert (instance != null);
            streamWriter.writeInt(instance.ordinal());
}