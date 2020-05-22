// in your setup
Scanner sc = new Scanner(_in).useDelimiter(Connection.DELIMETER);

public String receive() {
    try {
        return sc.next();
    } catch(IOException e) {
        return "";
    }

}