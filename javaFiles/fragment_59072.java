final int MIN_FILE_SIZE = 1024*10;
final int MAX_READ = 1024*1024*50;
final int FILE_COUNT_FRACTION = 4;

// Scour the location of the runtime for any usable files.
ArrayList<File> found = new ArrayList<>();
ArrayList<File> queue = new ArrayList<>();
queue.add(new File("./"));
while(!queue.isEmpty() && found.size() < testCount) {
    File tested = queue.remove(queue.size()-1);
    if(tested.isDirectory()) {
        queue.addAll(Arrays.asList(tested.listFiles()));
    } else if(tested.length()>MIN_FILE_SIZE){
        found.add(tested);
    }
}

// If amount of found files is not sufficient, perform test with new file.
if(found.size() < testCount/FILE_COUNT_FRACTION) {
    Logger.logInfo("Disk to CPU transfer benchmark failed to find "
            + "sufficient amount of files to read, slow version "
            + "will be performed!", found.size());
    return benchTransferSlowDC(testCount);
}

System.out.println(found.size());

byte[] block = new byte[MAX_READ];
Collections.shuffle(found);
RandomAccessFile raf = null;
long readB = 0;
try {
    long t0 = System.nanoTime();

    for(int i = 0; i<Math.min(found.size(), testCount); i++) {
        File file = found.get(i);
        int size = (int) Math.min(file.length(), MAX_READ);
        raf = new RandomAccessFile(file,"r");
        raf.read(block, 0, size);
        raf.close();
        readB += size;
    }
    long t1 = System.nanoTime();

    return ((double)readB/(1024*1024))/((double)(t1-t0)/(1000*1000*1000));
    //return (double)(t1-t0) / (double)readB;
} catch (Exception e) {
    Logger.logError("Failed to benchmark drive speed!", e);
    if(raf != null) try {raf.close();} catch(Exception ex) {}
    return 0;
}