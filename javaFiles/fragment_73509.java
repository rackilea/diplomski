public String readFromQueue1(MQPropsManager q1,
            MQGetMessageOptions getMsgOpts) {
        MQMessage msg = new MQMessage();
        String message = "";
        try {
            q1.getQueue().get(msg, getMsgOpts);
            message = msg.readStringOfCharLength(msg.getMessageLength());
        } catch (IOException ioe) {
        //  Failed to read string retreived from queue: q1.getQueueName()
        } catch (MQException mqe) {
        //  Failed to retreive message from queue: q1.getQueueName()
        }
        return message;
    }

public void writeToQueue2(String message) {
        MQMessage mqMessage = new MQMessage();
        mqMessage.format = MQConstants.MQFMT_STRING;
        mqMessage.messageType = MQConstants.MQMT_DATAGRAM;

        try {
            mqMessage.writeString(message);
            q2.getQueue().put(mqMessage, putMsgOpts);
        } catch (IOException ioe) {
        //  Failed to write message: message 
        } catch (MQException mqe) {
        //  Failed to put message: message on to the queue2
        }
    }