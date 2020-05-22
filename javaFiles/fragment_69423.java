/**
     * Close the response.
     * <p>
     * The entity input stream is closed.
     *
     * @throws ClientHandlerException if there is an error closing the response.
     */
    public void close() throws ClientHandlerException {
        try {
            entity.close();
        } catch (IOException e) {
            throw new ClientHandlerException(e);
        }
    }