SwingWorker<Void,Void> worker2 = new SwingWorker<Void, Void>(){
     @Override
     protected Void doInBackground() throws Exception {
              disable_all_checkbox();
              startSelectedTests();
              bla_bla_bla();
              return null;
     }
 };