public class DirectoryService {

    public static void main(String[] args) {
        FileSearchRecursiveTask task = new FileSearchRecursiveTask(new File("./DIR"));
        List<String> files = task.invoke();
        System.out.println("Total no of files with hello " + files.size());
    }

}

class FileSearchRecursiveTask extends RecursiveTask<List<String>> {
    private static final int TARGET_SURPLUS = 3;
    private File path;
    public FileSearchRecursiveTask(File file) {
        this.path = file;
    }

    @Override
    protected List<String> compute() {
        File directory = path;
        if(directory.isDirectory() && directory.canRead()) {
            System.out.println(Thread.currentThread() + " - Directory is " + directory.getName());
            return scan(directory);
        }
        return Collections.emptyList();
    }

    private List<String> scan(File directory)
    {
        File[] fileList = directory.listFiles();
        if(fileList == null || fileList.length == 0) return Collections.emptyList();
        List<FileSearchRecursiveTask> recursiveTasks = new ArrayList<>();
        List<String> filteredFileList = new ArrayList<>();
        for(File file: fileList) {
            System.out.println(Thread.currentThread() + "Looking into:" + file.getAbsolutePath());
            if(file.isDirectory())
            {
                if(getSurplusQueuedTaskCount() < TARGET_SURPLUS)
                {
                    FileSearchRecursiveTask task = new FileSearchRecursiveTask(file);
                    recursiveTasks.add(task);
                    task.fork();
                }
                else filteredFileList.addAll(scan(file));
            }
            else if(file.getName().contains("hello")) {
                filteredFileList.add(file.getAbsolutePath());
            }
        }

        for(int ix = recursiveTasks.size() - 1; ix >= 0; ix--) {
            FileSearchRecursiveTask task = recursiveTasks.get(ix);
            if(task.tryUnfork()) task.complete(scan(task.path));
        }

        for(FileSearchRecursiveTask task: recursiveTasks) {
            filteredFileList.addAll(task.join());
        }
        return filteredFileList;
    }
}