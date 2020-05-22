public class MainFrame extends JFrame {


    private JProgressBar progressBar;
    private PropertyChangeListener listener = new MyPropertyChangeListener();

   //in some place you have something like    
    readLogButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
               if(jb.getText().equals("Read Log"))  { // you compare objects with equals not with ==       
                File selectedFile = FileSelector.getInstance().selectFile();            
                Reader myWorker = new Reader();
                myWorker.addPropertyChangeListener(listener);
                myWorker.readLog(selectedFile);     
              }
            }
     });

     //And the private inner class (you can use anonymous class if you want it)
       private class MyPropertyChangeListener implements PropertyChangeListener{
                         @Override
                         public void propertyChange(final PropertyChangeEvent event) {
                            switch (event.getPropertyName()) {
                               case "progress":
                                    progressBar.setIndeterminate(false);
                                    progressBar.setValue((Integer) event.getNewValue());
                                    break;
                               case "message":
                                    progressBar.setString((String)event.getNewValue());
                                    break;
                            }
                        }
      }


    }