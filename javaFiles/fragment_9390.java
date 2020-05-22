/**
 * Map each character to a sub-trie.
 *
 * Could replace this with a 256 entry array of Tries but this will handle multi-byte character sets and I can discard
 * empty maps.
 *
 * Maintained at null until needed (for better memory footprint).
 *
 */
private Map<Character, TrieMap<K, V>> children = null;

....

/**
 * Create a new set of children.
 *
 * I've always wanted to name a method something like this.
 */
private void makeChildren() {
  if (children == null) {
    // Use a TreeMap to ensure sorted iteration.
    children = new TreeMap<>();
  }
}