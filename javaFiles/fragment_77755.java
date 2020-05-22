private StringBuilder buffer = new StringBuilder();

private String getBuffer() {
    try {
            // return current String content of the buffer
            return buffer.toString();
    } finally {
            // assign a new StringBuilder, before method returns
            buffer = new StringBuilder();
    }
}