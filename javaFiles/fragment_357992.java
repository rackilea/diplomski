// When you're finished producing records, you can 
   flush the producer to ensure it has all been `written` to Kafka and
   // then close the producer to free its resources.

finally {
  producer.flush();
  producer.close();
  }