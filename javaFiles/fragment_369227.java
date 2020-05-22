public class MailHelper {

    public void sendMail(){
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("MailHelper: Sending mail for 6s");
                for(int i = 0; i < 6; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(".");
                }
                System.out.println("MailHelper: Sent mail!");
            }
        });
        t.start();
    }

}