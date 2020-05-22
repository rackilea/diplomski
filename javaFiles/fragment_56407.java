int[] tally = new int[26];
StreamSupport.intStream(Spliterators.spliteratorUnknownSize(
  it, Spliterator.ORDERED | Spliterator.IMMUTABLE | Spliterator.NONNULL), false)
// now you have your stream and you can operate on it:
  .map(Character::toLowerCase)
  .filter(c -> c>='a'&&c<='z')
  .map(c -> c-'a')
  .forEach(i -> tally[i]++);