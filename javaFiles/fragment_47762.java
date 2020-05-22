public static void logIn(String name, String pass) {
try {
    Socket s = new Socket("localhost", 9000);
    //PrintStream out = new PrintStream(s.getOutputStream(), true, "UTF-8");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
    out.println(name + "," + pass);
    out.flush();

    BufferedReader in = new BufferedReader(new InputStreamReader(
            s.getInputStream(), "UTF-8"));

    System.out.println(in.readLine());

    out.close();
    in.close();
    s.close();
} catch (UnknownHostException exp) {
    exp.printStackTrace();

} catch (java.io.IOException exp) {
    exp.printStackTrace();
}
}


public static void main(String[] args) {
ArrayList<User> users = new ArrayList<User>();
users.add(new User("jmeno", "heslo"));
ServerSocket ss;
try {
    ss = new ServerSocket(9000);
    while (true) {
        Socket s = ss.accept();
        System.out.println("Accept...");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                s.getInputStream(), "UTF-8"));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"), true);
        String xmlpacket = "";
        String pom;

        pom = in.readLine();
        //while ((pom = in.readLine()) != null) {
            xmlpacket += pom;
            xmlpacket += "\n";
        //}
        int commaPos = xmlpacket.indexOf(',');
        int newlinePos = xmlpacket.indexOf('\n');
        String login = xmlpacket.substring(0, commaPos);
        String passwd = xmlpacket.substring(commaPos + 1, newlinePos);                        

        boolean clientExists = false;
        for (User us : users) {
            if (us.isUserNameAndPasswordRight(login, passwd)) {
                out.println("user is connected");
                clientExists = true;
                break;
            }
        }
        if (!clientExists)
            out.println("bad login");
        out.close();
        in.close();
        s.close();
    }
} catch (java.io.IOException exp) {
    System.out.println("chyba u socketu!");
}
}