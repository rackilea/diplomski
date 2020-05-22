List<String> strings = ...

for (int i = 0; i < strings.size(); i++) {
    if (strings.get(i).equalsIgnoreCase("fnord")) {
        break;
    }
}
if (i < strings.size()) {
    ...
}