public class Consumer<DATA> {

    private List<DATA> dataList = new ArrayList<DATA>();

    private ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public synchronized void consume(DATA data) {

        dataList.add(data);

        if(dataList.size() >= 1000) {

            threadPool.submit(new ConsumerWorker(data));
        }
    }

}