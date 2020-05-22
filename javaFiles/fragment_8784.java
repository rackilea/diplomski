String encoding = urlc.getContentEncoding();
if (encoding == null) {
    encoding = "UTF-8";
} else if (encoding.equalsIgnoreCase("ISO-8859-1")) { // Latin-1
    encoding = "Windows-1252"; // Windows Latin-1
}