// This is your current listener implementation
class CustomTreeSelectionListener implements TreeSelectionListener {

    // listeners to which the even will be forwarded
    private List<TreeSelectionListener> ownLIsteners;


    public void addListener( TreeSelectionListener newListener ) {
         ownListeners.add( newListener );
    }

    // add also removeListener( ....  ) 

    // TreeSelectionListener interface implementation...
    public void valueChanged( TreeSelectionEvent e ) {
           process( e ); // do what you do now

           // Forward the message.
           for( TreeSelectionListener listener : ownListeners ) {
                listener.valueChanged( e );
           }
    }

 }