public void nextTuple() {
    Utils.sleep(5000);

        //emit only 1 tuple - for testing
    if (!flag){
        Object msgId = "ID 6";  // this can be any object
        this.collector.emit(new Values(6), msgId);
        flag = true;
    }
}


@Override
public void ack(Object msgId) {
    //  msgId should be "ID 6"
    System.out.println("[HelloWorldSpout] ack on msgId" + msgId);
}