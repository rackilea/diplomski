class TestAppender extends AppenderSkeleton {
    public void doAppend(LoggingEvent event) {
         if(event.getLevel() == Level.Error) {
              throw new AssertionError("logged at error:" + event.getMessage());
         }
    }
}