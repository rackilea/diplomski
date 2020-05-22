/**
 * Optional. Sets a {@link FileLocker} to be used to guard files against
 * duplicate processing.
 * <p>
 * <b>The supplied FileLocker must be thread safe</b>
 * @param locker a locker
 */
public void setLocker(FileLocker locker) {