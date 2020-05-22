//list is a LinkedList
synchronized(list) {
    if(!list.isEmpty()) {
        ... list.getFirst()
    }
}