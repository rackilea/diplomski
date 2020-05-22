boolean exceptionOccured = false;
for(Widget w : widgets) {
    if(shouldDoStuff()) {
        try {
            // Do stuff to w.
        } catch(Exception e){
            exceptionOccured = true;  // do not throw yet.
            e.printStackTrace();
        }
    }
}
if (exceptionOccured) {
  throw new RuntimeException("Couldn't do stuff.");
}