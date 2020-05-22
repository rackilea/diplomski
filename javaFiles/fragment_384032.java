String[] names = new String[] {"bob dylan", "johny cash"};

List<String> splitNames = new ArrayList<>();
for (String name : names) {
    splitNames.addAll(Arrays.asList(name.split(" ")));
}