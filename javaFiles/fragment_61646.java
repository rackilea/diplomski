@Override
public void execute(Tuple tuple, BasicOutputCollector collector) {
   try {
      // do something which might fail here...
   } catch (Exception e) {
      // do you want to log the error?
      LOG.error("Bolt error {}", e);
      // do you want the error to show up in storm UI?
      collector.reportError(e);
      // or just put information on the queue for processing later
   }
}