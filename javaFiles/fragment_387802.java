public ClientThread(String ip) {
    // TODO Auto-generated constructor stub
    this.ipAddr=ip;

    try {
        s = new Socket(ipAddr, 502);
        i = s.getInputStream();
        o = s.getOutputStream();
    // ...
}

public int readStatus() {
    try {
        //s = new Socket(ipAddr, 502);
        //i = s.getInputStream();
        //o = s.getOutputStream();