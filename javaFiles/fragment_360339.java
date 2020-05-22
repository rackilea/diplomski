class MyTask implements Callable<Integer>{

  @Override
  public Integer call() throws TimeoutException{
    throw new TimeoutException(); 
  }
}

void usingCallable(MyTask e) {
    e.call(); // error: must catch Exception
}