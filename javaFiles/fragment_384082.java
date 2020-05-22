const ws = io(http);

ws.use(async(socket, next) => {

    try {
        await validateToken(socket.handshake.query.token));
        return next();
    } catch(e) {
        return next(new Error('Authentication error'));
    }

});

ws.on('connection', socket => {
      /* ... */
});