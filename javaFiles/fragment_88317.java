for (int i = 0; i < 2; i++) {
    Process p = new Process(getHost.getName(), "Tier1_" + i) {
        public void main(String[] args) throws MsgException {
        String mailbox = getName();
        while(true) {
          commReceived = Task.irecv(mailbox);
          commReceived.waitCompletion();
          if (commReceived.test()){
            task = commReceived.getTask();
            commReceived = null;
            Msg.info("Receive " + task.getName());
            task.execute();
            Msg.info("End to execute " + task.getName());
          }
        }
      });
      p.start();
}