byte[] data = params.getBytes("UTF-8");
conn.setFixedLengthStreamingMode(data.length);
...
OutputStream output = conn.getOutputStream();
// Note: you should use a finally block here
output.write(data);