long lastDataRecvTime = System.currentTimeMillis();
byte[] input;
while (true) {
    if(System.currentTimeMillis() - lastDataRecvTime >= 5 * 60 * 1000) {
        throw new RuntimeException("Nothing received for 5 minutes. Transfer starved. Exiting");
    }
    int availableBuf = request.getAvailableBufferSize();
    if(availableBuf == 0) {
        request.flush();
        continue;
    }
    input = new byte[Math.min(4096, availableBuf)];
    int length = bis.read(input);
    if (length == -1)
        break;

    if(length == 0) {
        try { Thread.sleep(1); } catch (Exception ignored){}
        continue;
    }

    lastDataRecvTime = System.currentTimeMillis();
    request.write(input, 0, length);
}
request.flush();
request.close();
bis.close();