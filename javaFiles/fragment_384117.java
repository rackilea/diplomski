socket.on('isActive', function (user) {
const userId = user.userId;
const user = usernames[userId];
const socketId = socket.id;
let response;
if(user) {
    // User is active
    response = {isActive: true};
} else {
    // User is not active
    response = {isActive: false};
}
const responseSocket = io.sockets.connected[socketId];
if(responseSocket) {
    responseSocket.emit('onIsActive', response);
}
});