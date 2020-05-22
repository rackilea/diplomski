Socket theSocket;
try {
    theSocket = new Socket("vuln2014.picoctf.com", 51818);
    BufferedReader inFile = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));

    String strGreet = inFile.readLine();
    String strData = inFile.readLine();
} catch (IOException e) {
    e.printStackTrace();
}