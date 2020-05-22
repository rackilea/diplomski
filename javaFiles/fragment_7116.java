try {
    Socket s = new Socket(IPaddress,px);
} catch(Exception e) {
    System.out.print("Nothing\n");
    continue;
}
System.out.print("Service discovered at port: " + px + "\n");