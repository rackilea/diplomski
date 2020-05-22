while ((line = buffer.readLine()) != null) {
    if (line.isEmpty()) {
        break;
    }
    length += line.length();
}