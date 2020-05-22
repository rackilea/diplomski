//while loope that run forever
// accept socket
    if(requests.size() == requests.getMaxSize()) {
        socket.getOutputStream().write("HTTP/1.0 505 Error\n\n".getBytes());
        socket.getOutputStream().write("<html><body>Try again</body></html>\n\n".getBytes());
        socket.close();
    } else {
            requests.add(socket);
    }