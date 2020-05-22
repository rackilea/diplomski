ByteArrayOutputStream bytes = new ByteArrayOutputStream();
TeeInputStream is = new TeeInputStream(getDataUrl(...), bytes);
try {
  // Pass is to parser here.
  parser.setInput(new InputStreamReader(is, "UTF-8"));
  // Note: please specify an encoding with InputStreamReader, maybe based on
  // the headers from getDataUrl.  
  ...
} finally {
  is.close();
}

// After parsing finishes, convert the bytes to a String.
String parsed = bytes.toString("UTF-8");
// If UTF-8 is not appropriate, use the encoding specified in headers from URL.