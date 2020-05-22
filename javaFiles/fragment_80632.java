public class Network implements NetworkListener 
{    
    public int  counter = 0 ;
    public void registered() 
    {
        System.out.println("network: " + counter);
        counter++;
        SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 fireCounterChanged( ... );
             }
        });
        if (counter>40) System.exit(0);
    }

    public void addChangeListener(...) {
         ....
    }

    public void removeChangeListener(...) {
         ....
    }
    private void fireCounterChanged(...) {
        // notify all listeners
    }  

}

// usage
ChangeListener l = new ChangeListener() {
       public void stateChanged(ChangeEvent e) {
           button.setText("counter: " + ((NetWork) e.getSource()).counter;
       }
};