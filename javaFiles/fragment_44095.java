import com.ibm.mq.MQEnvironment;
    import com.ibm.mq.MQQueue;
    import com.ibm.mq.MQQueueManager;
    import com.ibm.mq.constants.CMQC;
    int openOptions = CMQC.MQOO_INQUIRE + CMQC.MQOO_FAIL_IF_QUIESCING + CMQC.MQOO_INPUT_SHARED;

    MQEnvironment.hostname = "10.2.51.19";
    MQEnvironment.port = 1414;
    MQEnvironment.channel = "SW1_QM_CH1";

    MQQueueManager qMgr = new MQQueueManager("SW1_QM");

    MQQueue destQueue = qMgr.accessQueue("E_RETRY",   openOptions);
    System.out.println("E_RETRY size:" + destQueue.getCurrentDepth());
    destQueue.close();
    qMgr.disconnect();