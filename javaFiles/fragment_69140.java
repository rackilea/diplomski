public class Worker implements Runnable {
    final private int minIndex; // first index, inclusive
    final private int maxIndex; // last index, exclusive
    final private float[] data;

    public Worker(int minIndex, int maxIndex, float[] data) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.data = data;
    }

    public void run() {
        for(int i = minIndex; i < maxIndex; i++) {
            if(data[i] >= 0.75) {
                // do something interesting
            }
        }
    }
}


// *** Main Thread ***
float[] data = new float[12000];
int increment = data.length / 8;
for(int i = 0; i < 8; i++) {
    new Thread(new Worker(i * increment, (i + 1) * increment, data)).start();
}