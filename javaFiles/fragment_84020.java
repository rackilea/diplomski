// If your Base64 class doesn't have a decode method taking a string,
// find a better one!
byte[] decodedBytes = Base64.decodeBase64(stringBase64);
// Note the try-with-resources block here, to close the stream automatically
try (OutputStream stream = new FileOutputStream("F:\\xxx.doc")) {
    stream.write(decodedBytes);
}