ImmutableMultiset<String> first = ImmutableMultiset.of(
    "Green", "Green",
    "Blue",
    "Yellow", "Yellow", "Yellow",
    "Cyan", "Cyan");
ImmutableMultiset<String> second = ImmutableMultiset.of(
    "Green",
    "Yellow", "Yellow",
    "Magenta",
    "Black", "Black");

Multiset<String> result = Multisets.filter(
    Multisets.sum(first, second),
    Predicates.in(Multisets.intersection(first, second)));

System.out.println(result);  // [Green x 3, Yellow x 5]