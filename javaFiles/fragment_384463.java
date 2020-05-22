public static void main(String[] args) {
    try {
        MQEnvironment.hostname = "192.168.120.28";
        MQEnvironment.port     = 1415;
        MQEnvironment.channel  = "SFMS.TO.CBS";
        MQQueueManager qMgr = new MQQueueManager("GSCBBRQM");
    }

    catch (MQException ex) {
        System.out.println("CC="+ex.completionCode + " : RC="+ ex.reasonCode);
        }
}