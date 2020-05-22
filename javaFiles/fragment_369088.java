this.socket.setSoTimeout(5000);
BufferedReader br = new BufferedReader(
    new InputStreamReader(this.socket.getInputStream()));
StringBuilder sb = new StringBuilder();
try {
    int ch ;
    while ((ch == br.read()) != -1) {
        if (ch == 0) {
            String message = sb.toString();
            // process message
            sb.setLength(0);
        } else {
            sb.append((char) ch);
        }
    }
} catch (InterruptedIOException ex) {
    System.err.println("timeout!"); 
    ...
} finally {
    br.close();
}