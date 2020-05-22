BufferedReader reader;

try {
    reader = ... // initialization
} catch (some exception) {
    ...
} finally {
    if (reader != null) {
        reader.close();
    }
}