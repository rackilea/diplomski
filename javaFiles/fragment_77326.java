try (BufferedWriter bw = new BufferedWriter(new FileWriter(log, true));
        PrintWriter pw = new PrintWriter(new StringWriter())) {
    // do your processing here
} catch (IOException ex) {
    // do your exception handling
}