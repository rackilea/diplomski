public int getResponseCode() throws IOException {
    /*
     * We're got the response code already
     */
    if (responseCode != -1) {
        return responseCode;
    }

    /*
     * Ensure that we have connected to the server. Record
     * exception as we need to re-throw it if there isn't
     * a status line.
     */
    Exception exc = null;
    try {
        getInputStream();
    } catch (Exception e) {
        exc = e;
    }

    /*
     * If we can't a status-line then re-throw any exception
     * that getInputStream threw.
     */
    String statusLine = getHeaderField(0);
    if (statusLine == null) {
        if (exc != null) {
            if (exc instanceof RuntimeException)
                throw (RuntimeException)exc;
            else
                throw (IOException)exc;
        }
        return -1;
    }
    ...