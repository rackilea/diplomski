public void transferQueue(MQPropsManager q1) {
    String message = "";
    message = readFromQueue1(q1, getFirstMsgOpts);
    message = verifyMessage(message);   // just a check for empty or null
    writeToQueue2(message);
    q1.decrementMessagesLeftToProcess();  // decrement initial queue depth 

    while (q1.getMessagesLeftToProcess() > 0) {
        message = readFromQueue1(q1, getNextMsgOpts);
        message = verifyMessage(message);
        writeToQueue2(message);
        q1.decrementMessagesLeftToProcess();
    }
    closeQueue(q1);
}