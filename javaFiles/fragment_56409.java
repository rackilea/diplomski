int[] tally = new int[26];
Files.lines(Paths.get(file))
  .flatMapToInt(CharSequence::chars)
  .map(Character::toLowerCase)
  .filter(c -> c>='a'&&c<='z')
  .map(c -> c-'a')
  .forEach(i -> tally[i]++);