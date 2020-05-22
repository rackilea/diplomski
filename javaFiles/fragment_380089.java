while(!connected){
    //Do GET/POST to server to see if status is 200 OK.
    if (request.status == 200){
        connected = true;
        connectToWs();
    }
    // otherwise delay and re-attempt request.
}