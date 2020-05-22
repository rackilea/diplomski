OutputStream os;
try {
  os = ... 
  // do stuff
} finally {
  try { os.close(); } catch (Exception e) { }
}