public class MyValueDeserializer implements Deserializer<MyMessage>
{
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {
        this.isKey = isKey;
    }

    @Override
    public MyMessage deserialize(String s, byte[] value)
    {
        if (value == null) {
            return null;
        }

        try {

            (deserialize value into your MyMessage object)

            MyMessage message = new MyMessage();
            return message;

        } catch (IOException | RuntimeException e) {
            throw new SerializationException("Error deserializing value", e);
        }
    }

    @Override
    public void close()
    {

    }
}