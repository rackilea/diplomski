// in User somewhere...
void processFiles (List<ZippedFile> files) {

    LinkedList<ZippedFile> remaining = new LinkedList<ZippedFile>(files);

    // increase reference counts ahead of time so we hold the files
    // during this entire operation even if other users finish with
    // them in the mean time.
    for (ZippedFile file:remaining)
        file.wantAccess();

    while (!remaining.isEmpty()) {
        ZippedFile file = remaining.removeFirst();
        int status = file.beginAccess();
        if (status == ZippedFile.BEGIN_ERROR)
           file.finishAccess(); // decrease ref count 
        else if (status == ZippedFile.BEGIN_BUSY)
           remaining.addLast(file); // move to end of queue 
        else if (status == ZippedFile.BEGIN_OK) {
           processFileData(file); // do the work
           file.finishAccess(); // done with file
        }
    }

}