private static final int MAX_ENTRIES_ALLOWED = 100;
private static final long MAX_FILE_SIZE = 1L * 1024 * 1024; // 1 MB

protected boolean removeEldestEntry(Map.Entry eldest) {
    if (size() <= MAX_ENTRIES_ALLOWED) {
        return false;
    }

    File objFile = new File("t.tmp");
    if (objFile.length() > MAX_FILE_SIZE) {
        // Do something here to manage the file size, such as renaming the file
        // You won't be able to easily remove an object from the file without a more
        // advanced file structure since you are writing arbitrary sized serialized
        // objects. You would need to do some kind of tagging of each entry or include
        // a record length before each one. Then you would have to scan and rebuild
        // a new file. You cannot easily just delete bytes earlier in the file without
        // even more advanced structures (like having an index, fixed size records and
        // free space lists, or even a database).
    }

    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream(objFile, true); // Open for append
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));

        oos.writeObject(eldest.getValue());
        oos.close(); // Close the object stream to flush remaining generated data (if any).
        return true;
    } catch (IOException e) {
        // Log error here or....
        throw new RuntimeException(e.getMessage(), e); // Convert to RuntimeException
    } finally {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e2) {
                // Log failure - no need to throw though
            }
        }
    }
}