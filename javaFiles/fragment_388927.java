//Consumer - executed in a Thread
QueueingConsumer consumer = new QueueingConsumer(connection.createChannel());
boolean autoAck = false;
channel.basicConsume("hello", autoAck, consumer);

while (!Thread.current().isInterrupted())) {
  QueueingConsumer.Delivery delivery = consumer.nextDelivery();
  //...      
  channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
}