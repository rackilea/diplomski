class CommunicationManager implements Runnable
{
   private BlockingQueue<Message> message = new ArrayBlockingQueue<Message> (1000);
   private Messenger messenger = new Messenger();

   public CommunicationManager() {}

   public void run()
   {
      Message next = message.poll();
      if (next != null)
      {
         next.getSender().recieve(messenger.send(next.getMessage()));
      }
   }

   public void addMessage(Sender sender, String message)
   {
       try
       {
          while (!this.message.offer(new Message(sender, message), 1, TimeUnit.SECONDS)) {}
       } catch (InterruptedException e)
       {
          e.printStackTrace();
       }
   }
}