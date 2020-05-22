BlockingQueue<Message> queue = new LinkedBlockingQueue<Messsage>();
...
// producer thread(s) add a message to the queue
queue.add(message);
...
// consumer(s) wait for a message to be added to the queue and then removes it
Message message = queue.take();
...
// you can also wait for certain amount of time, returns null on timeout
Message message = queue.poll(10, TimeUnit.MINUTES);