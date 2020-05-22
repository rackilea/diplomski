if (input.contains("connect")) {
    String[] args = input.replaceAll("connect ", "").split(" ");
    String ip = args[0];
    int port = Integer.parseInt(args[1]);

    try {
        this.other = new Socket(ip, port);
        this.in = new BufferedReader(new InputStreamReader(this.other.getInputStream()));
        this.out = new PrintWriter(this.other.getOutputStream(), true);
        this.sendMessage("connect");
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
} else if (input.contains("listen")) {
    this.listening = true;
}