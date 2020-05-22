putMsgOpts = new MQPutMessageOptions();

    getFirstMsgOpts = new MQGetMessageOptions();
    getFirstMsgOpts.options = MQConstants.MQGMO_BROWSE_FIRST;

    getNextMsgOpts = new MQGetMessageOptions();
    getNextMsgOpts.options = MQConstants.MQGMO_BROWSE_NEXT;