private synchronized void writeObject(ObjectOutputStream out) throws IOException {
  synchronized(foo){
    synchronized(bar){
      out.defaultWriteObject();
}
}
}