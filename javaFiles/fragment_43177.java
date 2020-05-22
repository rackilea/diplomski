private void closeResource(AutoCloseable resource) {
    if (resource != null) {
        try {
            resource.close();
        } catch (Exception e) {
        }
    }
}