try {
        // Test access to the repository:
        file = new File(pdfRepository);
        if (!file.canRead())
            throw new SecurityException( "cannot read" );
        if (!file.canWrite())
            throw new SecurityException( "cannot write" );
        ...
} catch (SecurityException e) {
   // Get to your specific message using e.getMessage();
}