public class Main {

    public static void main(String[] args) throws InterruptedException {
        final MailHelper mh = new MailHelper();

        ThreadGroup mailThreadGroup = new ThreadGroup("mailGroup");
        Thread callSendmailThread = new Thread(mailThreadGroup, new Runnable() {

            @Override
            public void run() {
                System.out.println("Calling sendMail().");
                mh.sendMail();
                System.out.println("sendMail() returned.");
            }
        });
        callSendmailThread.start();
        callSendmailThread.join();
        System.out.println("callSendmailThread joined. Waiting for rest of ThreadGroup to finish.");

        // We cannot rely on ThreadGroup.activeCount() to give us an accurate number, and it could be zero!
        Thread[] mailThreads = new Thread[mailThreadGroup.activeCount() + 1];
        //Therefore retry enumerate until our array was large enough to hold all
        while ( mailThreadGroup.enumerate( mailThreads, true ) == mailThreads.length ) {
            mailThreads = new Thread[ mailThreads.length * 2 ];
        }

        for(Thread t : mailThreads){
            if(t != null && t.isAlive()){
                System.out.println("Joining thread " + t.getName());
                t.join();
                System.out.println("Thread " + t.getName() + " joined.");
            }
        }
        mailThreadGroup.destroy();
        System.out.println("Done!");

    }
}