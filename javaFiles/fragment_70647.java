// using a helper function can help normalize things
function readSocket(socket, nb, cb) {
  var r = socket.read(nb);
  if (r === null) {
    socket.once('readable', function() {
      readSocket(socket, nb, cb);
    });
    return;
  }
  cb(r);
}

// read in 1 byte
readSocket(socket, 1, function(buf) {
  // `buf` is a Buffer with `buf.length === 1`
});