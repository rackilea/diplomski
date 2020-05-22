try
{
    os.writeBytes("XN");
    os.writeByte('\n');
    os.flush();
    BufferedReader input = new BufferedReader(new InputStreamReader(is));
    String peso;
    while ((peso = input.readLine()) != null)
    {
        System.out.println("echo: " + peso);
    }
    os.close();
    is.close();
    echoSocket.close();
} catch (IOException e) {
    System.err.println("I/O failed on the connection to" + IpBilancia);
}