MQMessage getMsg;
qMQGetMessageOptions.options = CMQC.MQGMO_NO_WAIT | CMQC.MQGMO_BROWSE_FIRST;

while (true)
{
   getMsg = new MQMessage();
   inQ.get(getMsg, qMQGetMessageOptions);
   qMQGetMessageOptions.options = CMQC.MQGMO_NO_WAIT | CMQC.MQGMO_BROWSE_NEXT;
}