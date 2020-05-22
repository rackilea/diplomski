while (someCondition) {
    Map.Entry nextEntry = null;

    // This block is equivalent to polling
    {
         synchronized(s) {
             Iterator i = s.iterator(); // Must be in the synchronized block
             if (i.hasNext()) {
                 nextEntry  = i.next();
                 i.remove();
             }
         }
    }

    if (nextEntry != null) {
         // Process the entry
         ...
    } else {
         // Sleep for some time
         ...
    }
    // process
}