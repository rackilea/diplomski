public void removeRabbit( String name ){
  Iterator<Rabbit> rabbitIterator = rabbitList.iterator();
  while ( rabbitIterator.hasNext() ) {
    Rabbit next = rabbitIterator.next();
    if ( name.equals( next.getName() ) ){
      rabbitIterator.remove();
    }
  }
}