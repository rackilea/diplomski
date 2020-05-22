InputStream input = clientSocket.getInputStream();

String line;
while (null != (line = in.readLine())) {
    if("".equals(line)) break;
    ...
}