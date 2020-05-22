myClass.addEventListener( MY_EVENT, new EventHandler() {
    @Override public void onEvent( String type, Object payload ) {
        try {
            onEventHappens( Integer.parseInt(payload) );
        } catch (NumberFormatException nfe) {
            System.out.println("Exception: " + nfe)
        }
    } 
});

private void onEventHappens( int value ) {

}