} finally {
    try {
        classLoader.close();
    } catch (IOException e) {
        // failed to close. don't care. Should we?
    }
}