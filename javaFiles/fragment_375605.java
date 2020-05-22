public String getClientMessage() throws IOException {
    Reader r = new InputStreamReader(tempSocket.getInputStream());
    char[] buffer = new char[4096];
    StringBuilder sb = new StringBuilder();
    for(int len; (len = r.read(buffer)) > 0;)
         sb.append(buffer, 0, len);
    return sb.toString();
}