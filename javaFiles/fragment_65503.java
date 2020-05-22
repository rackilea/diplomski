wss.on('connection', function connection(ws) {

    // So here ws is the user got connected
    console.log('connected');    

    // This will be fired when connected user send message
    ws.on('message', function incoming(message) {
        ...
        // this will send message to the same user
        ws.send(JSON.stringify(response));
    });

});