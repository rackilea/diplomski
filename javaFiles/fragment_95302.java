PriorityQueue[] P = new PriorityQueue[10];
P[1] = new PriorityQueue<ClassEntry>();
ClassEntry entry = new ClassEntry(10,4);
P[1].add(entry);
//remove object with the same reference as the added one
P[1].remove(entry);