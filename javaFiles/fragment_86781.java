private static void addSimpleFormData(String paramName, String wert, PrintWriter body,
                                      final String boundary) {

    body.append("--").append(boundary).append(CRLF);
    body.append("Content-Disposition: form-data; name=\"" + paramName + "\"").append(CRLF);
    body.append("Content-Type: text/plain; charset=" + CHARSET).append(CRLF);
    body.append(CRLF);
    body.append(wert).append(CRLF);
    body.flush();
}

private static void addFileData(String paramName, String filename, byte[] byteStream, PrintWriter body,
                                OutputStream directOutput, final String boundary) throws IOException {

    body.append("--").append(boundary).append(CRLF);
    body.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + filename + "\"")
            .append(CRLF);
    body.append("Content-Type: application/octed-stream").append(CRLF);
    body.append("Content-Transfer-Encoding: binary").append(CRLF);
    body.append(CRLF);
    body.flush();

    directOutput.write(byteStream);
    directOutput.flush();

    body.append(CRLF);
    body.flush();
}

private static void addCloseDelimiter(PrintWriter body, final String boundary) {
    body.append("--").append(boundary).append("--").append(CRLF);
    body.flush();
}