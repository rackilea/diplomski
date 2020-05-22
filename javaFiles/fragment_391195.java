int e1 = q1.dequeue();
int e2 = q2.dequeue();

while (true) {
  if (e1 < e2) {
    merged.enqueue(e1);
    if (q1.isEmpty()) {
      // add remaining q2 elements
      while (!q2.isEmpty()) { 
        merged.enqueue(q2.dequeue());
      }
      break;
    }
    // take another element from q1
    e1 = q1.dequeue();
  } else {
    merged.enqueue(e2);
    if (q2.isEmpty()) {
      // add remaining q1 elements
      while (!q1.isEmpty()) { 
        merged.enqueue(q1.dequeue());
      }
      break;
    }
    // take another element from q2
    e2 = q2.dequeue();
  }
}