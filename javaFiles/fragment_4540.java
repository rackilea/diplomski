public class UUIDAsBytesEncoding extends CustomEncoding<UUID> {

    public UUIDAsBytesEncoding() {
        List<Schema> union = Arrays.asList(Schema.create(Schema.Type.NULL), Schema.create(Schema.Type.BYTES));
        union.get(1).addProp("CustomEncoding", "UUIDAsBytesEncoding");

        schema = Schema.createUnion(union);
    }

    @Override
    protected void write(Object datum, Encoder out) throws IOException {
        if(datum != null) {
            // encode the position of the data in the union
            out.writeLong(1);

            // convert uuid to bytes
            byte[] bytes = new byte[16];
            Conversion.uuidToByteArray(((UUID) datum), bytes, 0, 16);

            // write the data
            out.writeBytes(bytes);
        } else {
            // position of null in union
            out.writeLong(0);
        }
    }

    @Override
    protected UUID read(Object reuse, Decoder in) throws IOException {
        // get index in union
        int index = in.readIndex();
        if (index == 1) {
            // read in 16 bytes of data
            ByteBuffer b = ByteBuffer.allocate(16);
            in.readBytes(b);

            // convert
            UUID uuid = Conversion.byteArrayToUuid(b.array(), 0);

            return uuid;
        } else {
            // no uuid present
            return null;
        }
    }
}