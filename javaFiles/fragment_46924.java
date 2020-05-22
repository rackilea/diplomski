// rate = 512 permits per second or 512 bytes per second in this case
final RateLimiter rateLimiter = RateLimiter.create(512.0); 

while (file.hasMoreLines()) {
    String line = file.readLine();
    for (int i = 0; i < line.length(); i+=128) {
        byte[] bytes = line.substr(i, i+128).getBytes();
        rateLimiter.acquire(bytes.length);
        outputStream.writeBytes(bytes);
    }
}