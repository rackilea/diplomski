StyleClassedTextArea bigTextArea = new StyleClassedTextArea();
try (FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fileReader)) {
    StringBuilder sb = new StringBuilder();
    while ((haveRead = reader.read(buf)) != -1) {
        sb.append(buf);
    }
    bigTextArea.appendText(sb.toString());
} catch (IOException e) {
    log.error("Error while reading file", e);
}