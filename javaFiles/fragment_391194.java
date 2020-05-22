a = q1.dequeue();
    b = q2.dequeue();
    if (a < b) {
        merged.enqueue(a);
        merged.enqueue(b);
    } else if (b < a) {
        merged.enqueue(b);
        merged.enqueue(a);
    }