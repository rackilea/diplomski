public static void main(String[] args) throws Exception{
    BasicConfigurator.configure();
    LoggerRunner[] runners = new LoggerRunner[]{new LoggerRunner("t1"), new LoggerRunner("t2")};
    Thread t1 = new Thread(runners[0]);
    Thread t2 = new Thread(runners[1]);
    t1.start();
    t2.start();
    t1.join();
    System.out.println("Joined 1");
    t2.join();
    System.out.println("Joined 2");
    System.out.print(new String(runners[0].getLog()));
    System.out.print(new String(runners[1].getLog()));
}

private static class LoggerRunner implements Runnable{

    private final Logger logger;

    private ByteArrayOutputStream logs = new ByteArrayOutputStream();
    private final String name;
    public LoggerRunner(String name){
        this.name = name;
        logger = Logger.getLogger(name);
        logger.setAdditivity(false);
        logger.addAppender(new WriterAppender(new PatternLayout("%-1r [%t] %-5p %c %x - %m%n"), logs));
    }

    public byte[] getLog(){
        return logs.toByteArray();
    }

    @Override
    public void run() {
        logger.info(name + " started");
        try{
            Thread.sleep(1000);
            logger.info(name + " working");
            Thread.sleep(1000);
        }catch(Exception e){}
        logger.info(name + " finished");
    }
}