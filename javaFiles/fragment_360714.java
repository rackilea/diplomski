Deque<String> deque = new LinkedList<>();

deque.push("S1");
deque.push("S2");
deque.push("S3");
deque.push("S4");
deque.push("S5");
deque.push("S6");
deque.push("S7");
deque.push("S8");

String last = deque.pollLast();
String first = deque.pollFirst();