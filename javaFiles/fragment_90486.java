byte [] buffer = new byte[1024];
int bytesRead = 0;
while((bytesRead =input.read(buffer)) != -1) {
outputStream .write(buffer, 0,
bytesRead);
}