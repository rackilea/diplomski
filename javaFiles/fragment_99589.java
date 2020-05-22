public class Clients {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> new NormalClient().run());
        Thread thread2 = new Thread(() -> new NormalClient().run());
        Thread thread3 = new Thread(() -> new NormalClient().run());
        Thread thread4 = new Thread(() -> new NormalClient().run());
        Thread thread5 = new Thread(() -> new ShutdownClient().run());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

class NormalClient {
    void run() {
        try {
            try (Socket socket = new Socket("localhost", 10101);
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                for (int i = 0; i < 10; i++) {
                    out.write("hello " + i);
                    out.newLine();
                    out.flush();
                    sleep(1000);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ShutdownClient {
    void run() {
        try {
            try (Socket socket = new Socket("localhost", 10101);
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                sleep(8000);
                out.write("shutdown");
                out.newLine();
                out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}