autoReconnectController.addListener ( new AutoReconnectListener () {
   public void stateChanged ( AutoReconnectState state ) {
       if ( state == AutoReconnectState.CONNECTED ) {
           createOPCGroup(tagNames);
       }
   }
} );
autoReconnectController.connect ();