class Something {
   final JLabel label;

   Something() {
       // Instantiate label here
   }

   class MeaningOfLifeFinder implements BackgroundWorker {
       public void doInBackground(BackgroundEvent evt) {
           String meaningOfLife = findTheMeaningOfLife();
           evt.getWorker().publish(meaningOfLife);
       }

       public void process(BackgroundEvent evt) {
           label.setText("" + evt.getData());
       }

       public void done(BackgroundEvent evt) {}
       public void started(BackgroundEvent evt) {}
   }

   void someAction() {
       (new MeaningOfLifeFinder()).execute();
   }
}