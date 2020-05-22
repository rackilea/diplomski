public static long getAvailableInternalMemorySize() {
    File path = Environment.getDataDirectory();
    StatFs stat = new StatFs(path.getPath());
    long blockSize = stat.getBlockSize();
    long availableBlocks = stat.getAvailableBlocks();
    long size = availableBlocks * blockSize;
    long availableBlocksInKB = size /= 1024;
    long availableBlocksInMB = availableBlocksInKB /= 1024;
    return availableBlocksInMB;
}