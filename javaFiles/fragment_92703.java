List<Socket> clientSockets = Collections.synchronizedList(new ArrayList<Socket>());


//...when setting the labels:
synchronized (clientSockets) {
    for ( Socket socket : clientSockets ) {
        label.setText(socket.toString());
    }
}