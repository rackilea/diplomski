DelayQueue<DelayedSomething> q = new DelayQueue<>();

q.offer(somethingExpiringIn60s);
q.offer(somethingExpiringIn5s);
q.offer(somethingExpiringIn5min);

DelayedSomething shouldBeSomethingExpiringIn5s = q.take(); //[1]
DelayedSomething shouldBeSomethingExpiringIn60s = q.take(); //[2]
DelayedSomething shouldBeSomethingExpiringIn5min = q.take(); //[3]