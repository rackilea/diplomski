while ((line = br.readLine()) != null) {
    isStringBuilder.append(line).append("\r\n");
    if (url == null && !line.isEmpty()) {
        method = line.split("\\ ")[0];
        url = line.split("\\ ")[1];
    }
    if (line.isEmpty())
        break;
}