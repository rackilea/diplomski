public <T> reversePrint(Deque deque) {

 for (Iterator<T> iterator = deque.descendingIterator(); iterator .hasNext();){
      System.out.println(iterator .next());
    }
}