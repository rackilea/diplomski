public class ThreadDemo {
    public static void main(String[] args) {
        String dirName = "/dir/location";
        File[] fileList = new File(dirName).listFiles();
        int mid = fileList.length / 2;
        File[] fileListOne = Arrays.copyOfRange(fileList, 0, mid);
        File[] fileListTwo = Arrays.copyOfRange(fileList, mid, fileList.length);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Task(fileListOne));//T1
        executorService.execute(new Task(fileListTwo));//T2
        executorService.shutdown();
    }
}

class Task implements Runnable {
    private final File[] fileList;

    public Task(File[] fileList) {
        this.fileList = fileList;
    }

    @Override
    public void run() {
        try {
            String line = "";
            for (File file : fileList) {
                try (BufferedReader br = new BufferedReader(new FileReader(file.getName()))) {
                    while ((line = br.readLine()) != null) {
                        //parse few vaule
                    }
                    System.out.println("The file name is this :::: " + file.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}