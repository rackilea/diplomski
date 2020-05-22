ConcurrentMap<String,BlockingQueue<Message>> map = ...;
public Message consume(String str){
  return map.get(str).take();
}
public void produce(Message message){
  map.get(message.getAuthor()).put(message);
}