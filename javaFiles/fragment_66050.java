public class YearMonthCodec implements Codec<YearMonth> {

    public void encode(BsonWriter writer, YearMonth value, EncoderContext encoderContext) {

        writer.writeStartDocument();

        writer.writeName("year");
        writer.writeInt32(value.getYear());
        writer.writeName("month");
        writer.writeInt32(value.getMonth().getValue());

        writer.writeEndDocument();

    }

    public Class<YearMonth> getEncoderClass() {
        return YearMonth.class;
    }

    public YearMonth decode(BsonReader reader, DecoderContext decoderContext) {

        reader.readStartDocument();

        int year = reader.readInt32("year");
        int month = reader.readInt32("month");

        reader.readEndDocument();

        return YearMonth.of(year, month);

    }

}