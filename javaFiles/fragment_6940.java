...
channel.exchangeDeclare(EXCHANGE_NAME, "direct");

QueueingConsumer consumer = new QueueingConsumer(channel);

//Consume messages off named queue instead of anonymous queue
String namedQueue = "logqueue";
channel.basicConsume(namedQueue, true, consumer);

while(true) {
...