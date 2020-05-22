final HashMap<String, String> info = new HashMap<>();
if (title != null) {
    info.put("Title", title);
}
if (subject != null) {
    info.put("Subject", subject);
}
if (keywords != null) {
    info.put("Keywords", keywords);
}
if (creator != null) {
    info.put("Creator", creator);
}
if (author != null) {
    info.put("Author", author);
}

stamper.setMoreInfo(info);