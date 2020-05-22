if (ranges.isEmpty() || ranges.get(0) == full) {
    // Return full file.
    Range r = full;
    response.setContentType(contentType);
    response.setHeader("Content-Range", "bytes " + r.start + "-" + r.end + "/" + r.total);

    if (content) {
        // .....