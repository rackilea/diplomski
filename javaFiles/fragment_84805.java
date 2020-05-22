try (Scanner s = new Scanner(new URL(HASH_PROVIDER).openStream())) {
  // your code
} catch (Exception e) {
  e.printStackTrace();
} finally {
  System.exit(0);
}