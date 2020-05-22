MessageProcessor processor = new MessageProcessor() {
  @Override
  final public void run() {
    MessageProcessor(outgoingQueue).generate(outgoingQueue);                    
  }
};