int i;
for (i = 0; i < thumbLinks.size() - 2; i += 3) {
    String url0 = thumbLinks.get(i);
    String url1 = thumbLinks.get(i + 1);
    String url2 = thumbLinks.get(i + 2);
    // Use url0, url1 and url2
}
for (; i < thumbLinks.size(); i++) {
  // Deal with the trailing URLs here, one at a time...
}