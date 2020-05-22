class CommunicationControl
{
   private final ScheduledExecutorService scheduluer = Executors.newScheduledThreadPool(1);

   public void startManager()
   {
      final CommunicationManager manager = new CommunicationManager();
      scheduler.scheduleAtFixedRate(manager, 10, 1, SECONDS);
   }

   public void stopManager()
   {
      while (manager.getMessageCount() > 0)
      {
          try
          {
              Thread.sleep(manager.getMessageCount() * 1000);
          } catch (InterruptedException e)
          {
              e.printStackTrace();
          }
      }
      scheduler.shutdown();
   }
}