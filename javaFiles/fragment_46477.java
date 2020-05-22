private boolean isConnected() {
    try {
        servletResponse.getOutputStream().println("data");
        servletResponse.flushBuffer();
        return true;
    } catch (IOException e) {
        return false;
    }
}