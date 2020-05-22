public void execute(final Person p){
    //modify state of p in some way
    blockingQueue.put(new Action() {
        final String executionName = p.toString();
        public void doAction(){
            logger.info("Execution started: " + executionName);
            //do some other job
    });
}