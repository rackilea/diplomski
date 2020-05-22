if (thumbLinks.size() % 3 != 0) {
   // What do you want to do if it's not a multiple of three?
   throw new IllegalArgumentException(...);
}
for (int i = 0; i < thumbLinks.size(); i += 3) {
    String url0 = thumbLinks.get(i);
    String url1 = thumbLinks.get(i + 1);
    String url2 = thumbLinks.get(i + 2);
    // Use url0, url1 and url2
}