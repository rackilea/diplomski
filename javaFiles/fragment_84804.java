Scanner s = new Scanner(new URL(HASH_PROVIDER).openStream())
try {
  // your code
  System.exit(0);
} finally {
    s.close(); // Never executed
}