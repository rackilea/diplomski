private static final String STOP_PILL = "__STOP_PLEASE!!__";
...
// the consumer removes from the queue
String string = queue.take();
// it tests to see if it a pill, == is better than .equals here
if (string == STOP_PILL) {
   // the consumer should stop
   break;
}
...
// to stop the consumer, the producer puts the pill into the queue
queue.put(STOP_PILL);