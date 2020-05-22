public class ForcedMultithreading {

    public static void main(String[] args) {

        ForcedMultithreading f = new ForcedMultithreading();

        Data d = f.new Data();

        int numberOfThreads = 2;

        int perThreadLoad = d.size() / numberOfThreads;

        DataProcessor dp1 = f.new DataProcessor(d, "First processor", perThreadLoad);
        DataProcessor dp2 = f.new DataProcessor(d, "Second processor", perThreadLoad);

        Thread t1 = new Thread(dp1);
        Thread t2 = new Thread(dp2);

        t1.start();
        t2.start();

        dp1.displaydataToProcess();
        dp2.displaydataToProcess();

        d.printDataIndex();
    }

    class Data {

        private List<Integer> dataIndex = new ArrayList<>();

        Data() {
            for (int i = 0; i < 10; i++) {
                dataIndex.add(i);
            }
        }

        public int size() {
            return dataIndex.size();
        }

        public synchronized Integer extractOneData() {
            return dataIndex.remove(0);

        }

        public List<Integer> getDataIndex() {
            return dataIndex;
        }

        public void printDataIndex() {
            System.out.println("Data available:");
            for (Integer i : dataIndex) {
                System.out.print(i + " ");
            }
        }

    }

    class DataProcessor implements Runnable {

        private Data data;
        private String name;
        private int perThreadLoad;
        private List<Integer> dataToProcess = new ArrayList<>();

        DataProcessor(Data data, String name, int perThreadLoad) {
            this.data = data;
            this.name = name;
            this.perThreadLoad = perThreadLoad;
        }

        @Override
        public void run() {
            while (perThreadLoad > 0) {
                dataToProcess.add(data.extractOneData());
                this.perThreadLoad--;
            }
        }

        public void displaydataToProcess() {
            System.out.println("Data to be processed in " + name + ":");
            for (Integer i : dataToProcess) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}