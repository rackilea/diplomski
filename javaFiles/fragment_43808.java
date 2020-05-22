try {
        // Test access to the repository:
        file = new File(pdfRepository);
        if (!file.canRead())
            throw new CannotReadException();
        if (!file.canWrite())
            throw new CannotWriteException();
        ...
} catch (CannotReadException e) {
   // Do stuff for the specific error
} catch (CannotWriteException e) {
   // Do stuff for the specific error
}