public interface Processor {
   void execute(NotificationListener listener);

    interface NotificationListener {
        void processingCompleted();
    }  
}