} else if (token.startsWith("MSLH=")) {
    String value = getTokenValue(token);
    outputBuffer.append("ENSUP:").append(value).append("\n");
} else if (token.startsWith("ENSUP=")) {
    String value = getTokenValue(token);
    outputBuffer.append("MSLH:").append(value).append("\n");
}