protected static TransactionLog tranLog;

public static synchronized void process() {
    Random r = new Random();
    tranLog = new TransactionLog();
    String rid = r.nextInt(40000)+"";
    tranLog.setTxnid(rid);
}