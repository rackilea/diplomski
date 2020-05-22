int count = recorder.read(buffer, 0, buffer.length);
if (count == -1) {
    recorder.close();
    socket.close();
    break;
}
try {
    os = socket.getOutputStream();
    os.write(buffer, 0, count);