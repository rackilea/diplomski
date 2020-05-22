Thread1: put(o1); // count == items.length. Waiting on notFull.
Thread2: put(o2); // Waiting on notFull.
Thread3: put(o3); // Waiting on notFull.
Thread4: take();  // count -> items.length - 1
                  // There's space in the buffer, but we never signalled notFull.
                  // Thread1, Thread2, Thread3 will still be waiting to put.
         take();  // count -> items.length - 2, signal notFull!
                  // But what happens if Thread4 manages to keep the lock?
         take();  // count -> items.length - 3
         ...
         take();  // count -> 0
Thread1: // Wakes up from Thread4's signal.
         put(o1); // count -> 1
Thread2: put(o2); // Never signalled, still waiting on notFull.
Thread3: put(o3); // Never signalled, still waiting on notFull.