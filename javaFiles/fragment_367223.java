/**
 * @return true if the external storage is available, writable, 
 * and contains enough free space.
 */
public static boolean isExternalStorageAvailable() {
    if (!isExternalStorageWritable()) return false;
    long availableSize = getAvailableExternalMemorySize();
    if (availableSize < REQUIRED_STORAGE_SPACE) {
        return false;
    }
    return true;
}