public boolean isMultipart() {
    return (getContent() instanceof Multipart);
}

public String getContentAsString() {
    StringBuilder builder = new StringBuilder();
    // Append using BufferedReader/InputStreamReader. If necessary, do it lazily.
    return builder.toString();
}