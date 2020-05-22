try {
    Socket s = new Socket(IPaddress,px);
    System.out.print("Service discovered at port: " + px + "\n");
} catch(Exception e) {
    System.out.print("Nothing\n");
}