public class ExamExecution extends Thread {

    private SharedWaitingThreads waitingThreads;
    private static volatile Thread myThread;

    public ExamExecution(SharedWaitingThreads waitingThreads) {
        this.waitingThreads = waitingThreads;
    }

    @Override
    public void start() {
        myThread = new Thread(this);
        myThread.start();
    }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        ProtocolStatus p = new ProtocolStatus();
        UDPClient client = new UDPClient();
        if(status.getWorkingMode() == WorkingMode.CONTINUE_EXECUTION) {
            byte[] frameRestart = p.createResponseFrame(status.getWorkingMode());
            client.send(getIp(), getPort(), frameRestart);
            //send the frame and block the thread until the server gets the proper response
            try {
                waitingThreads.waitForAnswer(new ResponseToWait(getIp(), getPort(), Utils.TYPE_STATUS, frameRestart));
            } catch (InterruptedException ex) {
                Logger.getLogger(ExamExecution.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        if(status.getForce() == ForceStatus.START) {                
            //get data from database and initialize variables       
            .
            .
            .

            while(!executedTest.contains(testInExam.getTestId()) && myThread != null) {
                int attempts = 0;
                res = false;
                seqNumber = this.seqNumber.getValue();
                while(!res && (attempts < 3)) {
                    TestMemoryMap map = new TestMemoryMap(testInExam.getTestId());
                    byte[] frameConfig = pc.createConfigFrame(Utils.ID_RTU, (byte)1, (byte)0, 
                        Utils.MEM_MAP_VERSION, (byte)0, map.getMemoryMap().length, seqNumber, map.getMemoryMap());

                    res = client.send(getIp(), getPort(), frameConfig);

                    if(res) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " blocked waiting config answer");
                            waitingThreads.waitForAnswer(new ResponseToWait(getIp(), getPort(), Utils.TYPE_CONFIG, frameConfig));
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ExamExecution.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    attempts++;
                }
                System.out.println("Config frame received:" + res);

                if(res) {
                    byte[] frame = p.createResponseFrame(status.getWorkingMode());
                    client.send(getIp(), getPort(), frame);

                    try {
                        System.out.println(Thread.currentThread().getName() + " blocked waiting end execution answer");
                        waitingThreads.waitForAnswer(new ResponseToWait(getIp(), getPort(), Utils.TYPE_STATUS, frame));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ExamExecution.class.getName()).log(Level.SEVERE, null, ex);
                    }               
                }
                //add test to list of executed tests
                executedTest.add(testInExam.getTestId());
                nextTest = testInExam.getNextTestInExamId();
                if(nextTest != 0) {
                    testInExam = daot.getEntity(nextTest);
                    testId = testInExam.getTestId();
                }
            }
        } else if(status.getForce() == ForceStatus.END) {
            System.out.println("Stopping...");
            //abort the execution of the thread
            this.endExecution();

        }
    }

    private void endExecution() {
        synchronized(myThread) {
            this.myThread = null;
        }   
    }
}