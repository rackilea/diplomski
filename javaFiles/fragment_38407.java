// Feed myCaptureStream to TeeOutputStream
OutputStream myCaptureStream = new PipedOutputStream();

// Prepare to capture data being written to that output stream
InputStream myCaptureAsInputStream = new PipedInputStream(myCaptureStream);
Reader myCaptureReader = new InputStreamReader(myCaptureAsInputStream);
BufferedReader myCaptureBuffered = new BufferedReader(myCaptureReader, 1024);

// This must run on separate reader thread; in spin loop:
myCaptureBuffer.readLine