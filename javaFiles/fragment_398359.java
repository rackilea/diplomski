public void onConnectButtonPressed(EditText editText_ID){ 
    System.out.println("Received connect request from first fragment.");
    my_socket = new MySocket(); 
    my_socket.setListener(this);
    try { 
        my_socket.EstablishConnection(SERVER_ADDRESS, editText_ID); 
    } catch (URISyntaxException e) { 
        e.printStackTrace(); 
    } 
}