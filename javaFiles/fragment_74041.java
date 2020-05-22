while(true) {
  synchronized(futures) {
    if(futures.size() == inputs.size()) {
      ...
    }
  }
}