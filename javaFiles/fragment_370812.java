public void sendMyMail()
{
    Thread sendEmail = new Thread(new SendMail("abc@xyz.com"));
    sendEmail.start();
}

public class SendMail implements Runnable
{
    String sendTo;

    public SendMail(String sendTo)
    {
       this.sendTo = sendTo;
    }

    @Override
    public void run()
    {
    //Code to send Email
    }
}