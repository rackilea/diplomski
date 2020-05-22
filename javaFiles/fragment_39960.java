Socket connection = new Socket("50.7.98.106", 8398);

String request = "GET / HTTP/1.1\n\n";
OutputStream out = connection.getOutputStream();
out.write(request.getBytes(StandardCharsets.US_ASCII));
out.flush();

InputStream response = connection.getInputStream();

// Skip headers until we read a blank line.
int lineLength;
do {
    lineLength = 0;
    for (int b = response.read();
         b >= 0 && b != '\n';
         b = response.read()) {
        lineLength++;
    }
} while (lineLength > 0);

// rest of stream is audio data.
// ...