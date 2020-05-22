EvictingQueue<String> q = EvictingQueue.create(3);
Queue<String> syncQ =  Queues.synchronizedQueue(q);
syncQ.add("one");
syncQ.add("two");
syncQ.add("three");
syncQ.add("four");
System.out.println(q); // Prints [two, three, four]