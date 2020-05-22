char[] cbuf = new char[1024];
while (in.read(cbuf, 0, cbuf.length) != null) {
    fromServer =  new String(cbuf);
    System.out.print("Server: " + fromServer);
    if (fromServer.equals("Bye.")) {
        break;
    }

    fromUser = stdIn.readLine();
    if (fromUser != null) {
        System.out.print("Client: " + fromUser);
        out.println(fromUser);
    }
}