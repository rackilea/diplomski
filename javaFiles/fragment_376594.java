int filesize = .... obtained from Subsonic server for the track to be played

// establish the https connection using the self-signed certificate
// placed in the Android assets folder (code not shown here)
HttpURLConnection con = _getConnection(subsonic_url,"subsonic.cer")

// Establish the InputStream from the Subsonic server and
// the Piped Streams for re-serving the unencrypted data 
// back to the requestor
final InputStream is = con.getInputStream();
PipedInputStream sink = new PipedInputStream();
final PipedOutputStream source = new PipedOutputStream(sink);

// On a separate thread, read from Subsonic and write to the pipe 
Thread t = new Thread(new Runnable() {
                public void run () {
                    try {
                        byte[] b = new byte[1024];
                        int len;
                        while ((len = is.read(b,0,1024)) != -1)
                            source.write(b, 0, len);
                        source.flush();
                    }
                    catch (IOException e) {
                    }
                }});

t.start();
sleep(200); // just to let the PipedOutputStream start up

// Return the PipedInputStream to the requestor.
// Important to have the filesize argument
return new NanoHTTPD.Response(NanoHTTPD.Response.Status.OK, 
                              "audio/mpeg", sink, filesize);