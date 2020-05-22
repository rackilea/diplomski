String raw = conn.getHeaderField("Content-Disposition");
// raw = "attachment; filename=abc.jpg"
if(raw != null && raw.indexOf("=") != -1) {
    String fileName = raw.split("=")[1]; //getting value after '='
} else {
    // fall back to random generated file name?
}