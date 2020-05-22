package dirwatch;

import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;
import static java.nio.file.LinkOption.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class WatchDir {
    private final WatchService watcher;
    private final Map<WatchKey,Path> keys;
    private final boolean recursive;
    private boolean trace = false;

    private BlockingQueue<String> fileProcessingQueue;

    //******* processedFileQueue **** will be used by other threads to retrive unlocked files.. so I have 
    // kept as public final
    public final BlockingQueue<String> processedFileQueue;
    private volatile boolean closeProcessingThread;
    private volatile boolean closeWatcherThread;


    private void processFiles(){
        System.out.println("DirWatchProcessingThread Started");
        String fileName;
        outerLoop: while(!closeProcessingThread || !fileProcessingQueue.isEmpty()){
            try{
                fileName = fileProcessingQueue.poll(1000, TimeUnit.MILLISECONDS);
            }catch(InterruptedException ie){
                fileName = null;
            }

            if(fileName == null || fileName.equals("")){
                continue outerLoop;
            }

            long startTime = System.currentTimeMillis();
            innerLoop: while(true){
                FileInputStream fis = null;
                File file = new File(fileName);
                try{
                    fis = new FileInputStream(fileName);
                    break innerLoop;
                }catch(FileNotFoundException fnfe){
                    if(!file.exists() || file.isDirectory()){
                        System.out.println("File: '"+fileName+"has been deleted in file system or it is not file. Not processing this file.");
                        continue outerLoop;
                    }
                    try{
                        Thread.sleep(WatchDirParameters.millisToPuaseForFileLock);
                    }catch(InterruptedException ie){
                    }
                    if((System.currentTimeMillis() - startTime) > WatchDirParameters.millisToSwapFileForUnlocking){
                        if(fileProcessingQueue.offer(fileName)){
                            continue outerLoop;
                        }else{
                            startTime = System.currentTimeMillis();
                            continue innerLoop;
                        }
                    }
                }finally{
                    if(fis != null){
                        try{
                            fis.close();
                        }catch(IOException ioe){
                            ioe.printStackTrace();
                        }
                    }
                }
            }

            System.out.println("Queuing File: "+fileName);
            processedLoop:while(true){
                try{
                    if(processedFileQueue.offer(fileName, 1000, TimeUnit.MILLISECONDS)){
                        break processedLoop;
                    }
                }catch(InterruptedException ie){
                    //ie.printStackTrace();
                }
            }
        }
        closeWatcherThread = true;
        closeProcessingThread = true;
        System.out.println("DirWatchProcessingThread Exited");
    }

    /**
     * Process all events for keys queued to the watcher
     */
    private void processEvents(){
        System.out.println("DirWatcherThread started.");
        while(!closeWatcherThread) {
            // wait for key to be signalled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                // if we are returning from these method, it means we no longer wants to watch directory
                // we must close thread which may be waiting for file names in queue
                continue;
            }catch(ClosedWatchServiceException cwse){
                break;
            }

            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            try{
                for (WatchEvent<?> event: key.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();

                    if (kind == OVERFLOW) {
                        continue;
                    }

                    // Context for directory entry event is the file name of entry
                    WatchEvent<Path> ev = cast(event);
                    Path name = ev.context();
                    Path child = dir.resolve(name);
                    if(kind.equals(ENTRY_CREATE)){
                        // if directory is created, and watching recursively, then
                        // register it and its sub-directories
                        if (recursive) {
                            try {
                                if (Files.isDirectory(child, NOFOLLOW_LINKS)) {
                                    registerAll(child);
                                    continue;
                                }
                            } catch (IOException x) {
                                // ignore to keep sample readbale
                            }
                        }
                        while(true){
                            if(fileProcessingQueue.remainingCapacity() < 2){
                                // if only one last can be inserted then don't queue this we need 1 empty space in queue
                                // for swaping file names..
                                // sleep for some time so processing thread may have made some rooms to queue in fileQueue
                                // this logic will not create any problems as only one this thread is inserting in queue
                                try{
                                    Thread.sleep(200);
                                }catch(InterruptedException ie){
                                }
                                continue;
                            }
                            if(!fileProcessingQueue.offer(child.toString())){
                                // couldn't queue this element by whatever reason.. we will try to enqueue again by continuing loop
                                continue;
                            }else{
                                // file name has been queued in queue
                                break;
                            }
                        }
                    }
                }
                // reset key and remove from set if directory no longer accessible
                boolean valid = key.reset();
                if (!valid) {
                    keys.remove(key);

                    // all directories are inaccessible
                    if (keys.isEmpty()) {
                        break;
                    }
                }
            }catch(ClosedWatchServiceException cwse){
                break;
            }

        }
        closeProcessingThread = true;
        closeWatcherThread = true;
        System.out.println("DirWatcherThread exited.");
    }

    public void stopWatching(){
        try{
            watcher.close();
        }catch(IOException ioe){
        }
        closeProcessingThread = true;
        closeWatcherThread = true;
    }

    public static WatchDir watchDirectory(String dirName, boolean recursive) throws InvalidPathException, IOException, Exception{
        try{
            Path dir = Paths.get(dirName);
            final WatchDir watchDir = new WatchDir(dir, recursive);
            watchDir.closeProcessingThread = false;
            watchDir.closeWatcherThread = false;
            new Thread(new Runnable() {
                public void run() {
                    watchDir.processFiles();
                }
            }, "DirWatchProcessingThread").start();
            new Thread(new Runnable() {
                public void run() {
                    watchDir.processEvents();
                }
            }, "DirWatcherThread").start();
            return watchDir;
        }catch(InvalidPathException ipe){
            throw ipe;
        }catch(IOException ioe){
            throw ioe;
        }catch(Exception e){
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }

    /**
     * Register the given directory with the WatchService
     */
    private void register(Path dir) throws IOException {
        //WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        WatchKey key = dir.register(watcher, ENTRY_CREATE);
        if (trace) {
            Path prev = keys.get(key);
            if (prev == null) {
                System.out.format("register: %s\n", dir);
            } else {
                if (!dir.equals(prev)) {
                    System.out.format("update: %s -> %s\n", prev, dir);
                }
            }
        }
        keys.put(key, dir);
    }

    /**
     * Register the given directory, and all its sub-directories, with the
     * WatchService.
     */
    private void registerAll(final Path start) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Creates a WatchService and registers the given directory
     */
    private WatchDir(Path dir, boolean recursive) throws IOException {
        fileProcessingQueue = new ArrayBlockingQueue<String>(WatchDirParameters.fileQueueSize, false);
        processedFileQueue = new ArrayBlockingQueue<String>(WatchDirParameters.fileQueueSize, false);
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey,Path>();
        this.recursive = recursive;
        //CreateTxtFile.createFile(dir, 1);
        if (recursive) {
            System.out.format("Scanning %s ...\n", dir);
            registerAll(dir);
            System.out.println("Done.");
        } else {
            register(dir);
        }

        // enable trace after initial registration
        this.trace = true;
    }
}