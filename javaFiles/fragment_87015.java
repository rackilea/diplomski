int remaining = payloadSize;
int totalRead = 0;
int totalReadForChunk = 0;
while (true) {
  int num = read(buf, 0, min(remaining, chunkSize - totalReadForChunk))
  if (num < 0) break;  // i/o error
  appendData(<buf>, 0, num)
  totalReadForChunk += num
  remaining -= num
  if (remaining == 0) break;  // end of payload

  if (totalReadForChunk == chunkSize) {
     totalReadForChunk = 0;
     // read the chunk header (it's not neccessarily 0xc6)
     int header = read()
     if (header != currentStreamEmptyHeader) {  // 0xc6
       // ... parse the new rtmp message according to header value
       // (usually invoke the upper-level message reading method "recursively")
     }
  }
}