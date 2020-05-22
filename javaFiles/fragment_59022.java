try {
    BufferedReader bufferReader = new BufferedReader(new FileReader(path));
    StringBuilder sb = new StringBuilder();
    String content;
    while ((content = bufferReader.readLine()) != null) {
        sb.append(content);
        sb.append('\n');   // Add line separator
    }
    bufferReader.close();
} catch (Exception e) {
    return e.getMessage();
}

String result = sb.toString();