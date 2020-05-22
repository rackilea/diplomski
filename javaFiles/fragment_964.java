public String collectionToFormattedString(final List<?> list) {
    StringBuilder combined = new StringBuilder("<HTML>");
    for (Object elem : list) {
        combined.append(elem.toString()).append("<br />");
    }
    combined.append("</HTML>");
    return combined.toString();
}