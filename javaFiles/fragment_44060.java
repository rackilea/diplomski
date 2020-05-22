final Collection<String> names = new ArrayList<>();
final Collection<String> surnames = new ArrayList<>();

for (final List<String> value : mapOne.values()) {
    names.add(value.get(0));
    surnames.add(value.get(1));
}