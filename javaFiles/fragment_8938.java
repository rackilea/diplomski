BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
String read = "";
do {
    read = stdIn.readLine();
    System.out.println("Read from stdin: " + read);
    serverThread.send(read);

}
while (!read.equals("exit"));