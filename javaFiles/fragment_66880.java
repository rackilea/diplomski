String readLine(BufferedInputStream in)
{
    // HTTP carries both textual and binary elements.
    // Not using BufferedReader.readLine() so it does
    // not "steal" bytes from BufferedInputStream...

    // HTTP itself only allows 7bit ASCII characters
    // in headers, but some header values may be
    // further encoded using RFC 2231 or 5987 to
    // carry Unicode characters ...

    InputStreamReader r = new InputStreamReader(in, StandardCharsets.US_ASCII);
    StringBuilder sb = new StringBuilder();
    char c;
    while ((c = r.read()) >= 0) {
        if (c == '\n') break;
        if (c == '\r') {
            c = r.read();
            if ((c < 0) || (c == '\n')) break;
            sb.append('\r');
        }
        sb.append(c);
    }
    return sb.toString();
}

...

BufferedInputStream in = new BufferedInputStream(clientSocket.getInputStream());

String request = readLine(in);
// extract method, resource, and version...

String line;

do
{
    line = readLine(in);
    if (line.isEmpty()) break;
    // store line in headers list...
}
while (true);

// parse headers list...

if (request method has a message-body) // POST, etc
{
    if ((request version >= 1.1) &&
        (Transfer-Encoding header is present) &&
        (Transfer-Encoding != "identity"))
    {
        // read chunks...
        do
        {
            line = readLine(in); // read chunk header
            int size = extract value from line;
            if (size == 0) break;
            // use in.read() to read the specified
            // number of bytes into message-body...
            readLine(in); // skip trailing line break
        }
        while (true);

        // read trailing headers...
        line = readLine(in);
        while (!line.isEmpty())
        {
            // store line in headers list, updating
            // any existing header as needed...
        }

        // parse headers list again ...
    }
    else if (Content-Length header is present)
    {
        // use in.read() to read the specified
        // number of bytes into message-body...
    }
    else if (Content-Type is "multipart/...")
    {
        // use readLine(in) and in.read() as needed
        // to read/parse/decode MIME encoded data into
        // message-body until terminating MIME boundary
        // is reached...
    }
    else
    {
        // fail the request...
    }
}

// process request and message-body as needed..