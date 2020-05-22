DiscreteDomain<Character> domain = new DiscreteDomain<Character>(){
  // Implement DiscreteDomain for Character type
};

Range<Character> lower = Ranges.closed('a','z');
Range<Character> upper = Ranges.closed('A','Z');

HashSet<Character> set = new HashSet<Character>();
set.addAll(lower.asSet(domain));
set.addAll(upper.asSet(domain));