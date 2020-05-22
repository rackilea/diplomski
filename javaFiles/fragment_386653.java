public static void main(String[] args) {
    int i = 0;
    try {
        while (i < 30) {
            ClientResource cr = new ClientResource("http://localhost:8080/test");
            Representation repr = cr.get();
            System.out.println(">> call #"+i);
            Thread.sleep(100);

            i++;
        }
    } catch (Exception ex) {
        System.out.println(">> call #" + i + " failed");
        ex.printStackTrace();
    }
}