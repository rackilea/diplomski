public void print(Client c) {
    synchronized(queue) {
        queue.add(c);
    }
}

public class PrintWorker implements Runnable {
    @Override
    public void run() {
        while(true) {
            Client c = null;
            synchronized(queue) {
                if(!queue.isEmpty()) {
                    c = queue.remove(0);
                }
            }

            if(c != null) {
                // do print work
            }
            else {
                // maybe add sleep or wait here
                // to keep thread from spinning
                // too fast and burning CPU
            }
        }
    }
}