....
String namedQueue = "logqueue";
//declare named queue and bind log level routing keys to it.
//RabbitMQ will put messages with matching routing keys in this queue
channel.queueDeclare(namedQueue, false, false, false, null);
for (int level = 0; level < LOG_LEVELS.length; level++) {
   channel.queueBind(namedQueue, EXCHANGE_NAME, LOG_LEVELS[level]);
}
...