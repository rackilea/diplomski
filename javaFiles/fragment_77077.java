ProducerRecord<byte[],byte[]> record = new ProducerRecord<byte[],byte[]>("the-topic", key, value); 
      producer.send(myRecord,
           new Callback() {
               public void onCompletion(RecordMetadata metadata, Exception e) {
                   if(e != null) {
                      e.printStackTrace();
                   } else {
                      System.out.println("The offset of the record we just sent is: " + metadata.offset());
                   }
               }
           });