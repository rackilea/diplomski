int openOptions = CMQC.MQOO_INQUIRE;

    MQQueue mqQueue = mqQueueManager.accessQueue("AN.ALIAS.QUEUE.NAME", openOptions);
    int[] selectors = new int[1];
    int[] intAttrs = new int[1];
    byte[] charAttrs = new byte[64];
    selectors[0] = CMQC.MQCA_BASE_OBJECT_NAME;
    mqQueue.inquire(selectors, intAttrs, charAttrs);

    logger.trace("baseObjectName:{}", new String(charAttrs).trim());