CriarInterface p = new CriarInterface();
    new Thread(p).start();

}


public class CriarInterface implements Runnable {

    @Override
    public void run() {
        preencheLista();
        preencheLista2();
    }
}