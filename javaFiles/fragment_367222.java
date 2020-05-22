/**
 * @return the amount of free space on the external storage.
 */
public static long getAvailableExternalMemorySize() {
    File path = Environment.getExternalStorageDirectory();
    StatFs stat = new StatFs(path.getPath());
    long blockSize = stat.getBlockSize();
    long availableBlocks = stat.getAvailableBlocks();
    return availableBlocks * blockSize;
}