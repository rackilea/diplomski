public class Descoberta extends Thread {
private  final ArrayList<Gateway> a = new ArrayList<>();
public Descoberta( ArrayList<Gateway> a) {
        this.a = a;
    }

    @Override
    public void run() {
         synchronized (a) {
                while(true){ // your condition
                    a.wait();
                }
                a.notify();
         }
    }
}

public class Publication extends Thread {
private  final ArrayList<Gateway> b = new ArrayList<>();
public Publication(ArrayList<Gateway> b) {
        this.b = b;
    }

    @Override
    public void run() {
         synchronized (b) {
                while(true){ // your condition
                    b.wait();
                }
                b.notify();
         }
    }
}

public class EdgeServer {
    public static void main(String args[]) {
        private final ArrayList<Gateway> gatewaysCadastrados = new ArrayList<>();
        Thread clientThread = new Descoberta(gatewaysCadastrados);
        Thread publicationThread = new Publication(gatewaysCadastrados);
        clientThread.start();
        publicationThread.start();
    }
}