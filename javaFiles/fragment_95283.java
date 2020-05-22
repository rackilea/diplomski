while(iterator.hasNext()) {
    c = iterator.next();
    if(c.isDead()) {
        // Make a temporary iterator
        ListIterator<Creature> toDelete= c;
        // Step the regular one
        c = iterator.next();
        // Remove
        toDelete.remove();                  
    }
}