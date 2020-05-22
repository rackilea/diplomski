if (report) {
    String line = null;
    while ((line = br.readLine()) != null) {
        Debug.println(line);
    }
} else {
    consumeWholeStream(br);
}