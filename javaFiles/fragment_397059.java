byte[] bytes = new byte[8*1024];
OutputStream out = socket.getOutputStream();
// send data for given amount of time, e.g. 2000 ms
long endTime = System.currentTimeMS() + timeToSendDataMS;
do {
    out.write(bytes);
} while(endTime > System.currentTimeMS());