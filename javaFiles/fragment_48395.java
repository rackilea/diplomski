@Override
protected void process(List<String> chunks) {
    for (String line : chunks) {
        output.append(line);
    }
}