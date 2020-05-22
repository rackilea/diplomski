public class MyWorker extends SwingWorker<Void, Void> implements PropertyChangeListener {

    public MyWorker() {
      addPropertyChangeListener(this);
    }

    ....
    /* Your code */
    ....

   @Override
   public void propertyChange(PropertyChangeEvent evt) {

      if ("progress".equals(evt.getPropertyName())) {
        myProgressBar.setValue((Integer) evt.getNewValue());
      }
   }

}