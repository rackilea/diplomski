public class MyDeserializationSchema<T> implements DeserializationSchema<T> {


    private final Class<T> avrotype = (Class<T>) org.apache.avro.generic.GenericRecord.class;

    @Override
    public T deserialize(byte[] arg0) throws IOException {
        //do your stuff here, strip off your bytes
        //deserialize and create your GenericRecord 
        return (T) (myavroevent);
    }

    @Override
    public boolean isEndOfStream(T nextElement) {
        return false;
    }

    @Override
    public TypeInformation<T> getProducedType() {
        return TypeExtractor.getForClass(avrotype);
    }

}