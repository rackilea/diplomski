File file = null; 

do {
    try {
        file = new <....>
    } catch(FileNotFoundException e) {
        // Wait for some time.
    }
} while (file == null);

return file;