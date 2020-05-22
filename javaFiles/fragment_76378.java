@Override
    public void printFieldIdentityClause(Writer writer) throws ValidationException {
        try {
            writer.write(" SERIAL");
        } catch (IOException ioException) {
            throw ValidationException.fileError(ioException);
        }
    }