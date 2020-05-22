private String obtenerPrecios(String ids) {
    // ... your retrieval here ...
    if (result.size != 1) {
        throw new IllegalStateException("Single result is expected from database!");
    }
    return result.get(0);
}