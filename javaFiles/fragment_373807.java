public class Reloader implements Runnable {

    private Data data;

    public Reloader(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.reload();
    }

}