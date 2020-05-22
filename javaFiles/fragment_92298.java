public void pullAndFlushData(OutputStream output, URI uri, Params params) {
    InputStream input = doHttpRequest(uri, params);
    IOUtils.copyLarge(input, output);
    output.flush();
    output.close();
 }