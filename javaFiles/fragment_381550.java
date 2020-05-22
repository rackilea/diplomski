long offset = 0;
while (true) {
    request.setHeader("Range: bytes=" + offset + "-");
    request.send();
    request.readResponse();
    offset += theNumberOfBytesRead;
    Thread.sleep(someRespectfulAmountOfTime);
}