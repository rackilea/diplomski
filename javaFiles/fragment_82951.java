for (String line: customer) {
    if (line != null) {
        bw.write(line);
        bw.newLine();
    }
}