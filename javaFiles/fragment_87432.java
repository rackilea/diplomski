SpecificDatumWriter<Customer> writer = new SpecificDatumWriter<>(schema);
ByteArrayOutputStream os = new ByteArrayOutputStream();

try {
  BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(os, null);
  writer.write(customer1, encoder);
  e.flush();

  byte[] avroBytes = os.toByteArray();
  ProducerRecord<String, byte[]> record1 = 
    new ProducerRecord<>("CustomerCountry", "Customer One", avroBytes); 

  kafkaProducer.send(record1);
} finally {
  os.close();
}