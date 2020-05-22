SortedMap<String, Article> encyclopaedia = new TreeMap<>();
/* Populate the map. */
...
for (Article val : cyc.subMap("Sonar", "Tax Law").values()) {
  /* Process only Volume 17. */
}