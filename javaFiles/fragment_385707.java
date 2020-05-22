public class MyValueSerializer implements Serializer<MyMessage>
{
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {
        this.isKey = isKey;
    }

    @Override
    public byte[] serialize(String topic, MyMessage message)
    {
        if (message == null) {
            return null;
        }

        try {

            (serialize your MyMessage object into bytes)

            return bytes;

        } catch (IOException | RuntimeException e) {
            throw new SerializationException("Error serializing value", e);
        }
    }

    @Override
    public void close()
    {

    }
}

final IntegerSerializer keySerializer = new IntegerSerializer();
final MyValueSerializer myValueSerializer = new MyValueSerializer();
final KafkaProducer<Integer, MyMessage> producer = new KafkaProducer<>(props, keySerializer, myValueSerializer);

int messageNo = 1;
int kafkaKey = messageNo;
MyMessage kafkaValue = new MyMessage();
ProducerRecord producerRecord = new ProducerRecord<>(topic, kafkaKey, kafkaValue);
producer.send(producerRecord, new DemoCallBack(logTag, startTime, messageNo, strValue));