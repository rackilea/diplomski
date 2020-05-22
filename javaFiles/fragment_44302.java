public void run() {
    while (true) {
        try {
            String line = dis.readUTF();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}