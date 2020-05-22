create server socket
while (1) {
    try {
        accept client connection
        set up your I/O streams

        while (1) {
            interact with client until connection closes
        }
    } catch (...) {
        handle errors
    }
} // loop back to the accept call here